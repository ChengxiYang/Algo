package DynamicProgramming;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class MaxSubArray {

    /**
     * 状态dp(i): 以下标i结尾的最大连续子数组和
     * 状态转移方程: dp(i+1) = max{dp(i) + nums[i], dp(i)}
     * 利用滚动变量对空间进行优化
     */
    public int maxSubArray(int[] nums) {

        final int len = nums.length;
        int last = nums[0];
        int ret = nums[0];
        for (int i = 1; i < len; ++i) {
            last = Math.max(last + nums[i], nums[i]);
            if (last > ret) {
                ret = last;
            }
        }

        return ret;
    }

    //原始解答
    public int maxSubArray_(int[] nums) {

        final int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            if (dp[i] > ret) {
                ret = dp[i];
            }
        }
        return ret;
    }
}
