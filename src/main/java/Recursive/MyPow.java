package Recursive;

public class MyPow {

    /**
     * 累乘法计算容易超时
     */
    public double badMyPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        boolean flag = false;
        if (n < 0) {
            n = -n;
            flag = true;
        }
        double ret = x;
        for (int i = 1; i < n; ++i) {
            ret *= x;
        }
        if (flag) {
            return 1.0 / x;
        } else {
            return x;
        }
    }

    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1.0;
        }
        int N = n;
        return n > 0 ? recursivePower(x, N) : 1.0 / recursivePower(x, -N);
    }

    double recursivePower(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = recursivePower(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

}
