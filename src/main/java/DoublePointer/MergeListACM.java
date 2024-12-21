package DoublePointer;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/problem/25991
 * 来源：牛客网
 *
 * 现在有两个长度相等且为15的有序链表(都为升序)，现在需要你将两个链表合成一个，并且保证两个链表合并完后依旧是升序(链表值相等并不影响最后的输出结果)
 */
public class MergeListACM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrA = sc.nextLine().split(" ");
        String[] arrB = sc.nextLine().split(" ");
        String[] ans = new String[arrA.length + arrB.length];
        int i = 0, j = 0, k = 0;
        for(; i < arrA.length && j < arrB.length; ++k) {
            int a = Integer.parseInt(arrA[i]);
            int b = Integer.parseInt(arrB[j]);
            if (a < b) {
                ans[k] = arrA[i];
                ++i;
            } else {
                ans[k] = arrB[j];
                ++j;
            }
        }
        while (i < arrA.length) {
            ans[k++] = arrA[i++];
        }
        while (j < arrA.length) {
            ans[k++] = arrB[j++];
        }
        String out = "";
        for (String s : ans) {
            out = out + s + " ";
        }
        out.trim();
        System.out.println(out);

    }
}
