package EASY;

import java.util.ArrayList;
import java.util.List;

public class IsPalindromeDemo {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        int res = 0;
        while (x > 0 ) {
            res  = x % 10;
            list.add(res);
            x /= 10;
        }
        int i = 0;
        int j = list.size() - 1;
        while (j > i) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            --j;
            ++i;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindromeDemo demo = new IsPalindromeDemo();
        demo.isPalindrome(12321);
    }

    public void demo() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        for (int i = 0; i < a.size(); ++i) {

        }
    }

}
