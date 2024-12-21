import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapA = new HashMap<>();
        Map<Character, Character> mapB = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!mapA.containsKey(sc) && !mapB.containsKey(tc)) {
                mapA.put(sc, tc);
                mapB.put(tc, sc);
            } else {
                if (mapA.containsKey(sc)) {
                    if (tc != mapA.get(sc)) {
                        return false;
                    }
                }
                if (mapB.containsKey(tc)) {
                    if (sc != mapB.get(tc)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
