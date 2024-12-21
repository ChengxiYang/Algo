package DynamicProgramming;

public class MaxProfit {

    /**
     * dp[i]表示第i天的最大收益
     * 一维动态规划: dp[i] = max(di[i-1], prices[i] - miniPrice[i])
     * @param prices prices[i] 表示一支给定股票第 i 天的价格
     * @return 最大收益
     */
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        //第i天前的历史最低价
        int minPrice = prices[0];
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; ++i) {
            dp[i] = Math.max(dp[i-1], prices[i] - minPrice);
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return dp[len - 1];
    }

    /**
     给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
     在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     贪心思想: 转换为对价格上升区间求和
     */
    public int maxProfit2a(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }

    /**
     * 动态规划, 令dp(i)(0)表示第i天结束后不持有股票的最大收益, dp(i)(1)表示第i天结束后持有股票的最大收益
     * 状态转移方程: dp(i)(0) = max{dp(i-1)(0), dp(i-1)(1) + prices(i)}
     *             dp(i)(1) = max{dp(i-1)(0) - prices(i), dp(i-1)(1)}
     */
    public int maxProfit2(int[] prices) {
        int prevCash = 0;
        int prevStock = -prices[0];
        int curCash = 0;
        int curStock = 0;
        for (int i = 1; i < prices.length; ++i) {
            curCash = Math.max(prevCash, prevStock + prices[i]);
            curStock = Math.max(prevCash - prices[i], prevStock);
            prevCash = curCash;
            prevStock = curStock;
        }
        return curCash;
    }

    /**
     * 给定一个整数数组prices，其中prices[i]表示第i天的股票价格
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     */
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        //第i天结束后持有股票状态下的最大利润
        int[] dp_a = new int[len];
        //第i天结束后不持有股票且不处于冷冻期的最大利润
        int[] dp_b = new int[len];
        //第i天结束后不持有股票且处于冷冻期的最大利润(当天卖出股票)
        int[] dp_c = new int[len];
        dp_a[0] = -prices[0];
        dp_b[0] = 0;
        dp_c[0] = 0;
        for (int i = 1; i < prices.length; ++i) {
            dp_a[i] = Math.max(dp_a[i - 1], dp_b[i - 1] - prices[i]);
            dp_b[i] = Math.max(dp_b[i - 1], dp_c[i - 1]);
            dp_c[i] = dp_a[i - 1] + prices[i];
        }
        return Math.max(dp_b[len - 1], dp_c[len - 1]);
    }
}
