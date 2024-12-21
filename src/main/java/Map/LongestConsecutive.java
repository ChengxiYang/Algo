package Map;

import java.util.HashSet;
import java.util.Set;


/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
 */
public class LongestConsecutive {

    /**
     * 剪枝优化: 处于连续数字中的元素k除了起始元素外, 均存在前驱值k-1
     * 只要存在前驱值, 直接跳过寻找后继值的循环
     * 相比于直接寻找每一个元素的后继值去掉了很多重复判断（此时最坏时间复杂度是平方级别）
     * 2024年12月21日16时分，重做此题
     */
    public int longestConsecutive(int[] nums) {

        int maxLen = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
        }

        for (int i : set) {
            if (!set.contains(i-1)) {
                int cnt = 1;
                while (set.contains(++i)) {
                    ++cnt;
                }
                if (cnt > maxLen) {
                    maxLen = cnt;
                }
            }
        }
        return maxLen;

    }
}
