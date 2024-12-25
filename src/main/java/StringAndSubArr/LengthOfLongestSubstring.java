package StringAndSubArr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String test = " ";
        LengthOfLongestSubstring sol = new LengthOfLongestSubstring();
        sol.lengthOfLongestSubstring(test);
    }


    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        int bgn = 0, end = 0;
        int cnt = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (bgn < arr.length && end < arr.length) {
            cnt = 0;
            while (end < arr.length) {
                if (map.containsKey(arr[end])) {
                    break;
                }
                map.put(arr[end], end);
                cnt = end - bgn + 1;
                if (cnt > max) {
                    max = cnt;
                }
                ++end;
            }
            if (end == arr.length) {
                return max;
            }
            int tmp = map.get(arr[end]);
            for (int i = bgn; i <= tmp; ++i) {
                map.remove(arr[i]);
            }
            bgn = tmp + 1;
            cnt = end - bgn + 1;
            map.put(arr[end], end);
            end++;
        }
        return max;
    }
}
