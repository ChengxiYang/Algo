package StringAndSubArr;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {
        int[] test1 = {1,-1,0};
        SubarraySum ans = new SubarraySum();
        ans.subarraySumBruteForc(test1, 0);
    }

    /**
     * 暴力解法：遍历所有的sum(i, j) = nums[i] + numsi+1] + ... + numd[j]，考虑是否构成一个解
     * 注意，sum(i, j)是一个解，sum(i, j+1)仍有可能是一个解，如果nums[j+1] = 0
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumBruteForc(int[] nums, int k) {

        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum == k) {
                    ++ans;
                }
            }
            sum = 0;
        }
        return ans;
    }

    /**
     * 前缀和S_i = e0 + e1 + ... + ei
     * 转换为前缀和出现的个数思路求解：S_i - S_j-1 = k等价于S_j-1 = S_i - k, j = 0, 1, 2..., S_-1 = 0
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int ans = 0;
        int diff = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
            //这里的边界条件有两种情况
            //1. k = sum，即Sum[0:i]本身就是一个解，Sum[0:i] = S_i - 0, 需要在map在加入和为0的前缀数目为1
            //2. k = 0, 由于已经加了前缀和为0的数目为1，ans需要减去这个额外加的1才是真实解的数目
            ans += map.getOrDefault(sum - k, 0);
            if (k == 0) {
                ans -= 1;
            }

        }

        return ans;
    }
}
