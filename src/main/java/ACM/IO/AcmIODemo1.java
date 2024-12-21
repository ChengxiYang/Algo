package ACM.IO;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5657/D
 *
 * 输入数据包括多组:
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 0
 * 每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
 * 接下来n个正整数,即需要求和的每个正整数。
 * 输出:
 * 10
 * 15
 *
 */
public class AcmIODemo1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            //这里输入使用空格分开的
            String[] inputs = scanner.nextLine().split(" ");
            //使用逗号分开的处理方式
            String[] array = scanner.nextLine().split(",");
            //使用"->"分开的处理方式
            String[] arrayB = scanner.nextLine().split("->");
            if ("0".equals(inputs[0].trim())) {
                return;
            }
            int sum = 0;
            for (int i = 1; i < inputs.length; ++i) {
                sum += Integer.parseInt(inputs[i]);
            }
            System.out.println(sum);
        }
    }
}
