import java.util.HashMap;
import java.util.Map;

/**
 * @author chengxiyang
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = getMap(s);
        Map<Character, Integer> mapT = getMap(t);
        if (mapS.size() != mapT.size()) {
            return false;
        }
        for (Character c : mapS.keySet()) {
            int a = mapS.get(c);
            if (!mapT.containsKey(c)) {
                return false;
            }
            int b = mapT.get(c);
            if (a != b) {
                return false;
            }
//            if (mapS.get(c) != mapT.get(c)) {
//                return false;
//            }
        }
        return true;
    }

    private Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int value = map.get(c);
                map.put(c, ++value);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
