package DoublePointer;

/*
   如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
   字母和数字都属于字母数字字符。
   给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false

   来源：力扣（LeetCode）
   链接：https://leetcode.cn/problems/valid-palindrome
    */
public class IsPalindrome {

    //不要使用"" + s的方式进行字符串转换，时间效率很低
    //使用StringBuilder
    public boolean isPalindrome(String s) {
        StringBuilder removedS = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (('a' <= c && c <= 'z') ||
                    ('A' <= c && c <= 'Z') ||
                    ('0' <= c && c <= '9')) {
                if ('A' <= c && c <= 'Z') {
                    c = (char)(c + 'a' - 'A');
                }
                removedS.append(c);
            }
        }
        for (int i = 0, j = removedS.length() - 1; i <= j; ++i, --j) {
            if (removedS.charAt(i) != removedS.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    //官方题解中使用了Java标准API
    public boolean isPalindromeB(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
