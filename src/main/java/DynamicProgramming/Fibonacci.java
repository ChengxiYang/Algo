package DynamicProgramming;

public class Fibonacci {

    /**
     * 动态规划的一个简单demo
     * 等价于跳台阶问题
     * 状态转移方程f(n) = f(n-1) + f(n-2)
     * 这里只用到了常量内存
     * @param n Fibonacci数列的第n项
     * @return Fibonacci数列的第n项对应值
     */
    public int fibonacci(int n) {
        if (n < 3) {
            return 1;
        }
        int a = 1, val = 1;
        for (int i = 3; i <= n; ++i) {
            int tmp = val;
            val = val + a;
            a = tmp;
        }
        return val;
    }

    public int climbStairs(int n) {
        int[] history = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            if (i <= 1) {
                history[i] = 1;
            } else {
                history[i] = history[i - 1] + history[i - 2];
            }
        }
        return history[n];

    }

    /**
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     *
     * 请你计算并返回达到楼梯顶部的最低花费
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        //到达第i层的最小花费
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        //到达楼顶是len + 1
        for (int i = 2; i < len + 1; ++i) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[len];
    }
}
