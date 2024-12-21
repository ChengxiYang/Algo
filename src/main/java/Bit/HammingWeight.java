package Bit;

public class HammingWeight {

    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）
     * mask作为掩码循环左移即可
     */
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & mask) != 0) {
                ++count;
            }
            mask = mask << 1;
        }
        return count;
    }
}
