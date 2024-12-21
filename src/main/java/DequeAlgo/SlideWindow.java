package DequeAlgo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlideWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> retList = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();
        //初始化步骤
        for (int i = 0; i < k && i < nums.length; ++i) {
            if (deque.isEmpty()) {
                deque.addLast(nums[i]);
                continue;
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        retList.add(deque.peekFirst());

        for (int i = 1; i <= nums.length - k; ++i) {
            if (nums[i-1] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i+k-1] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i+k-1]);
            retList.add(deque.peekFirst());
        }
        return retList.stream().mapToInt(Integer::intValue).toArray();

    }
}
