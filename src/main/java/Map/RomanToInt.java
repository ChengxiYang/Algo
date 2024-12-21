package Map;

import java.util.*;

public class RomanToInt {
    Map<String, Integer> map;

    public RomanToInt() {
        map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            char n = s.charAt(i + 1);
            String cs = String.valueOf(c);
            String str = cs + String.valueOf(n);
            if (map.containsKey(str)) {
                sum += map.get(str);
                i += 2;
            }
            else {
                sum += map.get(cs);
                ++i;
            }
        }
        return sum;
    }
}
