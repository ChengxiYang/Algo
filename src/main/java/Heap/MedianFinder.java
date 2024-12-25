package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> largerHalf;

    private PriorityQueue<Integer> smallerHalf;


    public MedianFinder() {
        largerHalf = new PriorityQueue<>();
        smallerHalf = new PriorityQueue<>(Comparator.reverseOrder());
    }

    /**
     * 插入过程需要维护的性质：大的一半元素个数 - 小的一半元素个数 <= 1
     * 大的一半最小值 >= 小的一半最大值
     * @param num
     */
    public void addNum(int num) {
        if (largerHalf.isEmpty()) {
            largerHalf.add(num);
            return;
        }

        if (largerHalf.size() == smallerHalf.size()) {
            if (num >= smallerHalf.peek()) {
                largerHalf.add(num);
            } else {
                largerHalf.add(smallerHalf.poll());
                smallerHalf.add(num);
            }
        } else {
            if (num > largerHalf.peek()) {
                smallerHalf.add(largerHalf.poll());
                largerHalf.add(num);
            } else {
                smallerHalf.add(num);
            }
        }


    }

    public double findMedian() {
        if (largerHalf.size() == smallerHalf.size()) {
            return (largerHalf.peek() + smallerHalf.peek()) / 2.0;
        } else {
            return largerHalf.peek();
        }
    }

}
