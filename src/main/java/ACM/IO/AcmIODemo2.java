package ACM.IO;

import java.util.Scanner;

/**
 * 输入包括两个正整数a,b(1 <= a, b <= 1000),输入数据包括多组:
 * 1 5
 * 10 20
 * 输出:
 * 6
 * 30
 */
public class AcmIODemo2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //该读取方式一次循环读取两个数，并不换行
        while (sc.hasNext()) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println(a +b);
        }
    }
}
