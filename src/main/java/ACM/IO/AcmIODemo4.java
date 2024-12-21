package ACM.IO;

import java.util.Arrays;
import java.util.Scanner;

public class AcmIODemo4 {

    /**
     * 多个测试用例，每个测试用例一行。
     * 每行通过空格隔开，有n个字符，n＜100
     * 输入:
     * a c bb
     * f dddd
     * nowcoder
     * 输出:
     * a bb c
     * dddd f
     * nowcoder
     */
    public static void demo0(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            Arrays.sort(strs);
            String out = "";
            for (int i = 0; i < strs.length; ++i) {
                out += strs[i] + " ";
            }
            System.out.println(out.trim());

        }
    }

    /**
     * 多个测试用例，每个测试用例一行。
     * 每行通过,隔开，有n个字符，n＜100
     * a,c,bb
     * f,dddd
     * nowcoder
     * 输出:
     * 对于每组用例输出一行排序后的字符串，用','隔开，无结尾空格
     * a,bb,c
     * dddd,f
     * nowcoder
     */
    public static void demo1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(",");
            Arrays.sort(strs);
            String out = "";
            for (int i = 0; i < strs.length; ++i) {
                out += strs[i] + ",";
            }
            System.out.println(out.substring(0, out.length() - 1));

        }
    }
}
