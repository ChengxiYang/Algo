package StringAlgorithm;

import java.util.Arrays;
import java.util.Collections;

public class AddBinary {

    //输入中左边表示高位，右边表示地位
    public String addBinary(String a, String b) {
        char[] csa = a.toCharArray();
        char[] csb = b.toCharArray();
        //反转数组，以便从低位相加
        reverseArr(csa);
        reverseArr(csb);

        final char one = '1';
        StringBuilder ret = new StringBuilder();
        int bit = 0;
        int help = 0;
        for (int i = 0; i < Math.max(csa.length, csb.length); ++i) {

            if (i < csa.length && csa[i] == one) {
                ++bit;
            }
            if (i < csb.length && csb[i] == one) {
                ++bit;
            }
            bit += help;
            help = 0;

            if (bit == 0) {
                ret.append("0");
            }
            else if (bit == 1) {
                ret.append("1");
            }
            else if (bit == 2) {
                ret.append("0");
                ++help;
            }
            else {
                ret.append("1");
                ++help;
            }
            bit = 0;
        }
        if (help == 1) {
            ret.append("1");
        }
        return ret.reverse().toString();
    }

    void reverseArr(char[] cs) {
        for (int i = 0, j = cs.length - 1; i < j; ++i, --j) {
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
        }
    }
}
