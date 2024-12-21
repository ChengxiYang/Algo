package DynamicProgramming;

public class Rob {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
     * 链接：https://leetcode.cn/problems/house-robber
     * 状态dp(i)代表到下标i房间所偷窃的最大现金
     * 状态转移方程: dp(i+1) = max{dp(i), dp(i-1) + nums[i+1]}, 即当前房间i+1不偷窃或偷窃两种情况所获现金较大者
     */
    public int rob1(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int pprev = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        int cur = 0;
        for (int i = 2; i < len; ++i) {
            cur = Math.max(prev, pprev + nums[i]);
            pprev = prev;
            prev = cur;
        }
        return cur;
    }
}
