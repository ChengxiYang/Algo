package ACM.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 约瑟夫环问题
 */
public class Demo3 {

    /* Write Code Here */
    public static int calculate(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s == "+" || s == "-" || s == "*" || s == "/") {
                int a = stack.pop();
                int b = stack.pop();
                if (s == "+") {
                    stack.push(a+b);
                }
                if (s == "-") {
                    stack.push(a-b);
                }
                if (s == "*") {
                    stack.push(a*b);
                }
                if (s == "/") {
                    stack.push(a/b);
                }
            } else {
                int num = Integer.parseInt(s);
                stack.push(num);
            }
        }
        return stack.peek();

    }

    /* Write Code Here */
    public static String NifixToRPN(String nifix) {
        Stack<String> opps = new Stack<>();
        Stack<String> nums = new Stack<>();
        String regex = "/+|/-|/*|/|(/|)";
        String[] eles = nifix.split(regex);
        for (String s : eles) {
            if (s == ")") {
                String opp = opps.pop();
                String b = nums.pop();
                String a = nums.pop();
                String tmp = a + opp + b;

            }
            else if (s == "+" || s == "-" || s == "*" || s == "/" || s == "(" ) {
                opps.push(s);
            } else {
                nums.push(s);
            }
        }
        System.out.println(eles);
        return "";
    }


    public static void main(String[] args) {

        String ss = "(1+2)*3-4";
        NifixToRPN(ss);
        String[] s = {"2", "1", "+", "3", "*"};
        int a = calculate(s);
        System.out.println("" + a);


    }

    public static int solution(int n, int k, int m) {
        List<Integer> rings = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            rings.add(i);
        }
        int start = k;
        while (rings.size() > 1) {
            int out = (start + m - 1) % rings.size();
            rings.remove(out);
            start = out;

        }
        return rings.get(0);
    }
}
