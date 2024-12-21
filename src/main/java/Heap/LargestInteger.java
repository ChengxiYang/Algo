package Heap;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class LargestInteger {

    public int largestInteger(int num) {

        PriorityQueue<Integer> evenQ = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            } else {
                return 0;
            }
        });

        PriorityQueue<Integer> oddQ = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            } else {
                return 0;
            }
        });

        int tmp = num;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (tmp > 0) {
            int a = tmp % 10;
            stack.offerLast(a);
            if (a % 2 == 0) {
                evenQ.offer(a);
            } else {
                oddQ.offer(a);
            }
            tmp /= 10;
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            int a = stack.pollLast();
            if (a % 2 == 0) {
                sum = 10 * sum + evenQ.poll();
            } else {
                sum = 10 * sum + oddQ.poll();
            }
        }
        return sum;

    }
}
