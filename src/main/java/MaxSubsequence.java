import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author chengxiyang
 */
public class MaxSubsequence {
    public int[] maxSubsequence(int[] nums, int k) {

        Queue<Pair> queue = new PriorityQueue<>((a, b) -> {
            if (a.value > b.value) {
                return -1;
            } else if (a.value < b.value) {
                return 1;
            } else {
                return 0;
            }
        });
        for (int i = 0; i < nums.length; ++i) {
            Pair pair = new Pair();
            pair.index = i;
            pair.value = nums[i];
            queue.offer(pair);
        }
        Map<Integer, Integer> map = new TreeMap<>();
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            Pair pair = queue.poll();
            map.put(pair.index, pair.value);
        }
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ret[i++] = entry.getValue();
        }
        return ret;
    }

    static class Pair {
        int index;
        int value;
    }
}
