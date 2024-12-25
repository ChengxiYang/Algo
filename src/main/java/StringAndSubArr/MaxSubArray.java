package StringAndSubArr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSubArray {


    /**
     * 暴力解法: 从索引i往前遍历
     * 实际上内部循环求解了所有以索引i结束的连续子数组最大和，i+1再次开启的遍历与上一轮外循环大部分都是重复计算
     *
     * @param nums
     * @return
     */
    public int maxSubArrayBruteFore(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum = 0;
            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                if (sum >= max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 从索引i往后遍历的暴力求解思路，与第一种暴力解法思路完全一样，但是方向不一致
     *
     * @param nums
     * @return
     */
    public int maxSubArrayBruteFore2(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum >= max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 第一种暴力解法优化后的思路：f_i定义为以nums[i]结尾的所有连续子数组最大和
     * 那么， f_i = max{f_i-1 + nums[i], nums[i]}
     * 那么最大连续子数组为max{f_0, f_1, f_2, ..., f_n-1}
     * f_0 = nums[0]
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int f = nums[0];
        list.add(f);
        for (int i = 1; i < nums.length; ++i) {
            f = Math.max(f + nums[i], nums[i]);
            list.add(f);
        }
        return Collections.max(list);
    }

    /**
     * 暴力解法2对应的思路
     * f_i为所有以nums[i]开始的连续子数组最大和
     * f_n-1 = nums[n-1]
     * f_i-1 = max{f_i + nums[i-1], nums[i-1]}
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int f = nums[nums.length - 1];
        list.add(f);
        for (int i = nums.length - 2; i >= 0; --i) {
            f = Math.max(f + nums[i], nums[i]);
            list.add(f);
        }
        return Collections.max(list);
    }
}
