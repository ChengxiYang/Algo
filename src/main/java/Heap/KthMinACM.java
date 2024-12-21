package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/22904/1003
 * 来源：牛客网
 *
 * 第一行有三个整数，n m k,(1≤n,m,k≤2e5)
 * 第二行包含 n 个整数 a[i] ( 0 ≤ a[i] ≤ 1e9)
 * 接下来m行，每行代表一个操作。具体见题目描述
 * 5 4 3
 * 1 2 3 4 5
 * 2
 * 1 1
 * 1 3
 * 2
 * 每次查询输出一个第  k  小的数。
 */
public class KthMinACM {

    //队列限定的大小
    static int size;

    //最大优先级队列
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
        if (a > b) {
            return -1;
        } else if (a < b) {
            return 1;
        } else {
            return 0;
        }
    });

    //此题如果采用读字符串的方式再解析为整数会超时无法ac
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        size = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            add(sc.nextInt());
        }

        for (int j = 0; j < m; ++j) {
            int a = sc.nextInt();
            if (a == 1) {
                add(sc.nextInt());
            }
            if (a == 2) {
                System.out.println(get());
            }
        }
    }

    public static void add(int e) {
        pq.offer(e);
        if (pq.size() > size) {
            pq.poll();
        }
    }

    public static int get() {
        if (pq.size() < size) {
            return -1;
        }
        return pq.peek();
    }
}
