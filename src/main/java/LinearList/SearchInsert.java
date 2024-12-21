package LinearList;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 */
public class SearchInsert {

    /**
     * 二分查找的一个小变种demo
     * 最后与mid位置值比较并判断边界条件
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (target < nums[mid]) {
                high = mid - 1;
            }
            else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
            mid = (low + high) / 2;
        }

        if (target > nums[mid]) {
            return mid + 1;
        }
        return Math.max((mid - 1), 0);

    }
}
