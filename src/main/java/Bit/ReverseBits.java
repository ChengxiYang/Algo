package Bit;

public class ReverseBits {

    /**
     * 颠倒给定的 32 位无符号整数的二进制位。
     * 很巧妙地利用了霍纳法则 & 循环移位
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res <<= 1;
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
