package Map;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        TopKFrequent sol = new TopKFrequent();
        sol.topKFrequent(nums, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        //1. hashmap统计每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //2. 对hashmap转换为list，按value即频次降序排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (t1, t2) -> {
            if (t1.getValue() > t2.getValue()) {
                return -1;
            } else if (t1.getValue() < t2.getValue()) {
                return 1;
            } else {
                return 0;
            }
        });

        // 取list前k个元素
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        //1. hashmap统计每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //2. 按map中key的value定义最大堆,注意堆中元素的优先顺序依赖于map!
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            return map.get(b) - map.get(a);
        });

        for (Integer key : map.keySet()) {
            heap.add(key);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = heap.poll();
        }
        return ans;
    }

}
