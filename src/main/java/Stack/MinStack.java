package Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小栈的实现思路：存储每次push操作时栈中所有元素当前的最小值
 */
public class MinStack {

    private List<Integer> miniStack;

    public MinStack() {
        this.miniStack = new ArrayList<>();
    }

    public void push(int val) {
        if (miniStack.isEmpty()) {
            miniStack.add(val);
            miniStack.add(val);
            return;
        }
        int size = miniStack.size();
        int preMin = miniStack.get(size - 1);
        miniStack.add(val);
        if (val < preMin) {
            miniStack.add(val);
        } else {
            miniStack.add(preMin);
        }
    }

    public void pop() {
        miniStack.remove(miniStack.size() - 1);
        miniStack.remove(miniStack.size() - 1);

    }

    public int top() {
        return miniStack.get(miniStack.size() - 2);
    }

    public int getMin() {
        return miniStack.get(miniStack.size() - 1);
    }

}
