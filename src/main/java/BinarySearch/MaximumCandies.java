package BinarySearch;

/**
 * 分糖果问题
 * 给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，但 无法 再将两堆合并到一起。
 *
 * 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。
 *
 * 返回每个小孩可以拿走的 最大糖果数目
 *
 * 链接：https://leetcode.cn/problems/maximum-candies-allocated-to-k-children
 */
public class MaximumCandies {

    /**
     * 该解法在数据量大的情况下容易超时
     * 可以进行优化
     * @param candies
     * @param k
     * @return
     */
    public int maximumCandiesB(int[] candies, long k) {
        long sum = 0;
        for (int n : candies) {
            sum += n;
        }
        if (sum < k) {
            return 0;
        }
        int max = 1;
        long heaps = sum;
        while (heaps >= k) {
            heaps = 0;
            ++max;
            for (int i = 0; i < candies.length; ++i) {
                heaps += candies[i] / max;
            }
        }
        return max - 1;
    }

    //对解法B进行二分查找优化
    public int maximumCandies(int[] candies, long k) {
        //这里必须是long类型，否则对于很大对测试数据会产生溢出导致结果错误
        long sum = 0;
        for (int n : candies) {
            sum += n;
        }
        if (sum < k) {
            return 0;
        }
        int min = 1;
        int max = (int)(sum / k);
        int ans = min;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (check(candies, k, mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return ans;

    }

    public boolean check(int[] candies, long k, int val) {
        long heaps = 0;
        for (int i = 0; i < candies.length; ++i) {
            heaps += candies[i] / val;
        }
        return heaps >= k;
    }
}
