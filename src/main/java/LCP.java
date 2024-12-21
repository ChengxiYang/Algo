public class LCP {

    public String longestCommonPrefix(String[] strs) {
        String lcp = strs[0];
        for (int i = 0; i < strs.length; ++i) {
            lcp = calPrefix(lcp, strs[i]);
        }
        StringBuilder stringBuilder;
        return lcp;
    }

    String calPrefix(String a, String b) {
        char[] csa = a.toCharArray();
        char[] csb = b.toCharArray();
        int i = 0;
        while (i < csa.length && i < csb.length) {
            if (csa[i] != csb[i]) {
                break;
            }
            ++i;
        }
        if (i == 0) {
            return "";
        }
        return a.substring(0, i);
    }

    /**
     * 二分法与牛顿迭代法 注意越界问题
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 0;
        int r = x;
        int m = (l + r) / 2;
        while (l < r - 1) {
            m = (l + r) / 2;
            long tmp = (long) m * m;
            if (tmp == x) {
                return m;
            } else if (tmp > x) {
                r = m;
            } else {
                l = m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        String[] strs ={"flower","flow","flight"};
        LCP lcp = new LCP();
//        lcp.longestCommonPrefix(strs);
        lcp.mySqrt(2147483647);
    }
}
