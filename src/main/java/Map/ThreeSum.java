package Map;

import java.util.*;

public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; ++i) {
            int a = num[i];
            if (a > 0) {
                break;
            }
            int j = i + 1;
            int k = num.length - 1;
            while (j < num.length && j < k) {
                int b = num[j];
                int c = num[k];
                if (a + b + c > 0) {
                    --k;
                }
                else if (a + b + c < 0) {
                    ++j;
                }
                else {
                    ArrayList<Integer> tris = new ArrayList<>();
                    tris.add(a);
                    tris.add(b);
                    tris.add(c);
                    list.add(tris);
                    ++j;
                    --k;
                }
            }
        }
        return list;

    }

    public List<List<Integer>> _threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        Set<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int[] arr = new int[set.size()];
        int i = 0;
        for (int v : set) {
            arr[i++] = v;
        }
        for (int j = 0; j < arr.length; ++j) {
            int target = arr[j];
            for (int k = j + 1; k < arr.length; ++k) {
                if (set.contains(-(arr[j] + arr[k]))) {
                    ArrayList<Integer> tris = new ArrayList<>();
                    tris.add(arr[j]);
                    tris.add(arr[k]);
                    tris.add(-(arr[k] + arr[j]));
                    list.add(tris);
                }
            }
        }
        return list;
    }
}
