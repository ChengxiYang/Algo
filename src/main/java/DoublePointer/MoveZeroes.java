package DoublePointer;

public class MoveZeroes {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * 标准的双指针技巧
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int low = 0;
        int high = 0;
        while (low < nums.length && nums[low] != 0) {
            ++low;
        }
        high = low + 1;
        while (high < nums.length) {
            if (nums[high] != 0) {
                nums[low] = nums[high];
                nums[high] = 0;
                ++low;
            }
            ++high;
        }
    }
}
