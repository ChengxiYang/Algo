
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String lcp = "";
        if (strs == null) {
            return lcp;
        }
        lcp = strs[0];
        for (int k = 1; k < strs.length; ++k) {
            lcp = longestCommonPrefix(lcp, strs[k]);
            if ("" == lcp) {
                return lcp;
            }
        }
        return lcp;

    }

    public String longestCommonPrefix(String s1, String s2) {
        String prefix = "";
        if (s1 == null || s2 == null) {
            return prefix;
        }
        int len = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < len && s1.charAt(i) == s2.charAt(i)) {
            ++i;
        }
        return s1.substring(0, i);
    }
}
