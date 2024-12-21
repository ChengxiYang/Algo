package Math;

public class ReverseInteger {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int ret = 0;
        int tmp = 0;
        int UA = Integer.MAX_VALUE / 10;
        int UB = Integer.MAX_VALUE % 10;
        int LA = Integer.MIN_VALUE / 10;
        int LB = Integer.MIN_VALUE % 10;
        while(x != 0) {
            tmp = x % 10;
            x = x / 10;
            if (ret > UA || (ret == UA && tmp > UB)) {
                return 0;
            }
            if (ret < LA || (ret == LA && tmp < LB)) {
                return 0;
            }
            ret = ret * 10 + tmp;
        }
        return ret;
    }
}
