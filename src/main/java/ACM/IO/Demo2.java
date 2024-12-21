package ACM.IO;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/19306/1002
 *
 * 试计算在区间1 到n 的所有整数中，数字x（0 ≤ x ≤ 9）共出现了多少次？
 * 例如，在1到11 中，即在1、2、3、4、5、6、7、8、9、10、11 中，数字1 出现了4 次。
 * 输入共1行，包含2个整数n、x，之间用一个空格隔开。
 * 输出共1行，包含一个整数，表示x出现的次数。
 */
public class Demo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int sum = 0;
        for (int k = 1; k <= n; ++k) {
            sum += getCount(k, x);
        }
        System.out.println(sum);
    }

    public static int getCount(int n, int x) {
        int cnt = 0;
        while (n > 0) {
            if (n % 10 == x) {
                ++cnt;
            }
            n = n / 10;
        }
        return cnt;
    }
}
