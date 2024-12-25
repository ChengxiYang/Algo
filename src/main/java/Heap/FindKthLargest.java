package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : nums) {
            heap.add(i);
        }
        int res = 0;
        for (int i = 0; i < k; ++i) {
            res = heap.poll();
        }
        return res;
    }

}
