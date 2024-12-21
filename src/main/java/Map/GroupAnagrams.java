package Map;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> ansMap = new HashMap<>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = Arrays.toString(strArr);
            if (ansMap.containsKey(key)) {
                List<String> value = ansMap.get(key);
                value.add(str);
            } else {
                List<String> value = new ArrayList<>();
                value.add(str);
                ansMap.put(key, value);
            }
        }
        return new ArrayList<>(ansMap.values());

    }

}
