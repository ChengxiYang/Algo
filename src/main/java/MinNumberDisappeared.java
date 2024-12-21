public class MinNumberDisappeared {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberDisappeared (int[] nums) {
        // write code here
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; ++i) {
            int val = Math.abs(nums[i]);
            //数字重复出现也只修改一次
            if (val <= len && nums[val - 1] > 0) {
                nums[val - 1] = -1 * nums[val - 1];
            }
        }
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
