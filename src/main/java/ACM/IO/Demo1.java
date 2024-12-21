package ACM.IO;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/19306/1001
 * 输入的第一行有一个数T，表示试卷的数量；接下来的每2行，第一行有一个数n，表示当前试卷上数字的个数；第二行有n个数字a_i，表示这张试卷上的每一个数。
 * 对每张试卷，输出一行两个数，分别表示这些数字的极差和方差，中间用空格分开。其中极差是整数，方差是保留到小数点后3位的浮点数。
 * 2
 * 5
 * 5 4 3 2 1
 * 7
 * 333 494 655 991 101 591 941
 * 输出:
 * 4 2.000
 * 890 86075.959
 */
public class Demo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        while (sc.hasNextLine()) {
            String inputA = sc.nextLine();
            ++cnt;
            if (cnt == 1) {
                continue;
            }
            String inputB = sc.nextLine();
            int nums = Integer.parseInt(inputA);
            String[] scores = inputB.split(" ");
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            double sum = 0.0;
            for (int i = 0; i < scores.length; ++i) {
                int tmp = Integer.parseInt(scores[i]);
                if (tmp > max) {
                    max = tmp;
                }
                if (tmp < min) {
                    min = tmp;
                }
                sum += tmp;
            }
            double mean = sum / scores.length;
            double var = 0;
            for (int i = 0; i < scores.length; ++i) {
                var += Math.pow((Integer.parseInt(scores[i]) - mean), 2);
            }
            var = var /  scores.length;
            System.out.println(max - min + " " + String.format("%.3f", var));
        }
    }
}
