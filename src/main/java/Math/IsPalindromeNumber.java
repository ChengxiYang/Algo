package Math;

public class IsPalindromeNumber {

    /**
     * 数字是否回文
     * 这个地方隐含地考虑了输入数字反转后溢出的情况，回文数反转后是自身，一定不会溢出
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int y = 0;
        while (tmp != 0) {
            int a = tmp % 10;
            tmp = tmp / 10;
            y = y * 10 + a;
        }
        return y == x;
    }
}
