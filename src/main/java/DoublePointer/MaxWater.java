package DoublePointer;

public class MaxWater {
    /**
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater (int[] arr) {
        // write code here
        int maxPos = getMax(arr);
        int l = 0;
        int left = arr[l];
        int r = arr.length - 1;
        int right = arr[r];
        int sum = 0;
        for (int i = l + 1; i < maxPos; ++i) {
            if (arr[i] > left) {
                left = arr[i];
            } else {
                sum += left - arr[i];
            }
        }
        for (int j = r - 1; j > maxPos; --j) {
            if (arr[j] > right) {
                right = arr[j];
            } else {
                sum += right - arr[j];
            }
        }
        return sum;
    }

    //子数组[start, end)内的最大高度位置
    int getMax(int[] arr) {
        int max = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
}
