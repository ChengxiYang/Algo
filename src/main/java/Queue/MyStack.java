package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈
 */
public class MyStack {

    private Queue<Integer> qA;

    private Queue<Integer> qB;

    public MyStack() {
        qA = new ArrayDeque<>();
        qB = new ArrayDeque<>();
    }

    public void push(int x) {
        qA.offer(x);
    }

    public int pop() {
        while (qA.size() > 1) {
            qB.offer(qA.poll());
        }
        int ret = qA.poll();
        Queue<Integer> tmp = qA;
        qA = qB;
        qB = tmp;
        return ret;
    }

    public int top() {
        int ret = pop();
        qA.offer(ret);
        return ret;
    }

    public boolean empty() {
        return qA.isEmpty();
    }
}
