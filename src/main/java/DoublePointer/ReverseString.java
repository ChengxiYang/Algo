package DoublePointer;

public class ReverseString {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
     *
     * 标准的对撞指针技巧
     */
    public void reverseString(char[] s) {
        char tmp = 'a';
        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
