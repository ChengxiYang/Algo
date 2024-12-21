package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环问题
 */
public class Solution {

    public List<Integer> solution(int n, int s) {

        boolean[] flags = new boolean[n + 1];
        boolean yellow = true;
        boolean red = false;
        //全部初始化为红色
        for (int k = 0; k <= n; ++k) {
            flags[k] = red;
        }
        //每一轮命令
        for (int i = 1; i <= s; ++i) {
            for (int j = i; j <= n; j += i) {
                if (flags[j] == yellow) {
                    flags[j] = red;
                } else {
                    flags[j] = yellow;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int k = 1; k <= n; ++k) {
            if (flags[k] == yellow) {
                result.add(k);
            }
        }
        return result;

    }
}
