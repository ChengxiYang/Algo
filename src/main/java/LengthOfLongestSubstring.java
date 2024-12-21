import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0;
        int len = s.length();
        int begin = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int prev = map.get(c);
                //这一步骤可以去掉？
                for (int j = begin; j < prev; ++j) {
                    map.remove(s.charAt(j));
                }
                map.put(c, i);
                begin = prev + 1;
            } else {
                map.put(c, i);
                int tmp = i - begin + 1;
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }
}
