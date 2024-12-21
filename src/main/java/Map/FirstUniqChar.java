package Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FirstUniqChar {

    /**
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1
     * 两次遍历，第一次统计每个字符出现的次数，存储在map中，第二次判断是否只出现一次
     */
    public int firstUniqChar(String s) {

        HashSet<Integer> a;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
