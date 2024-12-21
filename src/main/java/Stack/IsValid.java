package Stack;

import java.util.Stack;

public class IsValid {

    public boolean isValid(String s) {
        char l1 = '(';
        char r1 = ')';
        char l2 = '{';
        char r2 = '}';
        char l3 = '[';
        char r3 = ']';
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == l1 || c == l2 || c== l3) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char a = stack.pop();
                if (c == r1 && a != l1) {
                    return false;
                }
                if (c == r2 && a != l2) {
                    return false;
                }
                if (c == r3 && a != r3) {
                    return false;
                }
            }
        }
        return true;
    }
}
