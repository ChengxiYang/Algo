package DynamicProgramming;

public class LongestPalindrome {

    /**
     * 这里是一个二维动态规划问题
     * 定义状态dp(i, j)：s[i:j]是否为回文字符串
     * dp(i, j) = dp(i+1, j-1) && s[i] == s[j], j >= i + 2
     * 初始状态: dp(i, i) = true; dp(i, i+1) = (s[i] == s[i+1])
     */
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        //max和start分别设置为1和0是合理的，不能随便乱设置
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[arr.length][arr.length];

        for (int i = 0; i < arr.length; ++i) {
            dp[i][i] = true;
            if (i + 1 < arr.length && arr[i] == arr[i+1]) {
                dp[i][i+1] = true;
                max = 2;
                start = i;
            }
        }

        //这里典型地利用了子问题重叠性质
        for (int len = 3; len <= arr.length; ++len) {
            for (int i = 0; i < arr.length; ++i) {
                int j = i + len - 1;
                if (j < arr.length ) {
                    if (dp[i+1][j-1] && arr[i] == arr[j]) {
                        dp[i][j] = true;
                        if (len > max) {
                            max = len;
                            start = i;
                        }
                    }
                    else {
                        dp[i][j] = false;

                    }
                }
            }
        }
        return s.substring(start, start + max);


    }


        //这个动态规划对于相同字符构成的回文串这种情况不正确
    public String longestPalindrome_(String s) {

        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int k = 1; k < s.length(); ++k) {
            int i = k - 1 - dp[k-1];
            if (i >= 0 && s.charAt(i) == s.charAt(k)) {
                dp[k] = dp[k-1] + 2;
            }
            else if (s.charAt(k-1) == s.charAt(k)) {
                dp[k] = 2;
            } else {
                dp[k] = 1;
            }
        }
        int l = 0;
        int max = -1;
        for (int k = 0; k < dp.length; ++k) {
            if (dp[k] > max) {
                max = dp[k];
                l = k;
            }
        }
        return s.substring(l - max + 1, l + 1);

    }
}
