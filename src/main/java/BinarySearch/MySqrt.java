package BinarySearch;

public class MySqrt {
    //利用二分逼近的技巧求解
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        int mid = 0;
        int ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid > x / mid) {
                high = mid - 1;
            }
            if (mid <= x / mid) {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}
