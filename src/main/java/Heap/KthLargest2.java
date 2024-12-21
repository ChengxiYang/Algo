package Heap;

import java.util.PriorityQueue;

public class KthLargest2 {

    private PriorityQueue<Integer> pq;

    private int k;

    public void KthLargest(int k, int[] nums) {
        this.k = k;
        //传入的比较器定义了最小优先级队列
        this.pq = new PriorityQueue<>((o1, o2) -> {
            if (o1 - o2 < 0) {
                return -1;
            } else if (o1 - o2 > 0) {
                return 1;
            } else {
                return 0;
            }
        });
        for (int i = 0; i < nums.length; ++i) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {

        pq.offer(val);
        if (pq.size() > this.k) {
            pq.poll();
        }
        return pq.peek();
    }
}
