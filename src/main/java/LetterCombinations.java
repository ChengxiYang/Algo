import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    private Map<Integer, char[]> map;
    void Solution() {
        map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        result.add("");
        for (int i = 0; i < digits.length(); ++i) {
            int num = Integer.valueOf(digits.charAt(i) + "");
            result = dMul(result, map.get(num));
        }
        return result;
    }

    public List<String> dMul(List<String> list, char[] eles) {
        List<String> ret = new ArrayList<>();
        for (String s : list) {
            for (char c : eles) {
                ret.add(s + c);
            }
        }
        return ret;
    }
}
