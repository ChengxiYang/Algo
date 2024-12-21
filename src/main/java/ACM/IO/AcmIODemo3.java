package ACM.IO;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入有两行，第一行n
 * 第二行是n个字符串，字符串之间用空格隔开
 * 5
 * c d a bb e
 * 输出:
 * a bb c d e
 */
public class AcmIODemo3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //读入行计数器
        int cnt = 0;
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            ++cnt;
            if (cnt == 1) {
                continue;
            }
            Arrays.sort(strs);
            for (int i = 0; i < strs.length; ++i) {
                System.out.print(strs[i] + " ");
            }
        }
    }
}
