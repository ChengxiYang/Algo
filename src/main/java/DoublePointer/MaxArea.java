package DoublePointer;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量
 *
 * 链接：https://leetcode.cn/problems/container-with-most-water
 */
public class MaxArea {

    /**
     * 2024年12月25日 重做此题
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return max;
    }
}
