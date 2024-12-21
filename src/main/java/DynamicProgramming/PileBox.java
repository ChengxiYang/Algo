package DynamicProgramming;

import java.util.Arrays;

public class PileBox {

    public int pileBox(int[][] box) {
        Arrays.sort(box, (a, b) -> {
            if (a[2] > b[2]) {
                return -1;
            } else if (a[2] < b[2]){
                return 1;
            } else {
                return 0;
            }
        });
        //以箱子i为顶时, 所能堆出的最大高度
        //状态转移方程: dp[i] = map{dp[0], dp[1], ..., dp[i-1]} + height[i], 如果箱子i满足堆放条件
        //平方复杂度
        int[] dp = new int[box.length];
        dp[0] = box[0][2];
        for (int i = 1; i < box.length; ++i) {
            int max = box[i][2];
            for (int j = i - 1; j >= 0; --j) {
                int cur = box[i][2];
                if (box[i][2] < box[j][2] &&
                    box[i][1] < box[j][1] &&
                    box[i][0] < box[j][0]) {
                    cur += dp[j];
                }
                if (max < cur) {
                    max = cur;
                }
            }
            dp[i] = max;

        }
        int ret = dp[0];
        for (int i = 1; i < dp.length; ++i) {
            if (dp[i] > ret) {
                ret = dp[i];
            }
        }
        return ret;
    }
}
