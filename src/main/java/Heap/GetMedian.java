package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class GetMedian {

    private PriorityQueue<Integer> largerHeap = new PriorityQueue<>();

    private PriorityQueue<Integer> smallerHeap = new PriorityQueue<>(Comparator.reverseOrder());


    public void Insert(Integer num) {
        if (largerHeap.isEmpty()) {
            largerHeap.add(num);
            return;
        }
        if (smallerHeap.isEmpty()) {
            if (num > largerHeap.peek()) {
                smallerHeap.add(largerHeap.poll());
                largerHeap.add(num);
            } else {
                smallerHeap.add(num);
            }
            return;
        }

        if (num > smallerHeap.peek()) {
            largerHeap.add(num);
            int lSize = largerHeap.size();
            int sSize = smallerHeap.size();
            if (lSize > (sSize + 1)) {
                smallerHeap.add(largerHeap.poll());
            }
        } else {
            smallerHeap.add(num);
            int lSize = largerHeap.size();
            int sSize = smallerHeap.size();
            if (sSize > (lSize + 1)) {
                largerHeap.add(smallerHeap.poll());
            }
        }
    }

    public Double GetMedian() {
        int lsize = largerHeap.size();
        int sSize = smallerHeap.size();
        if ((lsize + sSize) % 2 == 1) {
            if (lsize > sSize) {
                return largerHeap.peek() + 0.0;
            } else {
                return smallerHeap.peek() + 0.0;
            }

        } else {
            return (largerHeap.peek() + smallerHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        GetMedian solution = new GetMedian();
        int[] test = {5,2,3,4,1,6,7,0,8};
        for (int i : test) {
            solution.Insert(i);
            solution.GetMedian();
        }
    }
}
