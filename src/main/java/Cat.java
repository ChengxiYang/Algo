import java.util.*;

//上交所面试题
public class Cat {
    public int solution(int[][] input) {
        int s = input[0][0];
        //收割目标数
        int t = input[0][1];
        //日期与可以收割的叮当猫数目map, 日期排好序
        Map<Integer, Integer> map = new TreeMap<>();
        for (int k = 1; k < input.length; ++k) {
            if (input[k][0] == 0) {
                continue;
            }
            for (int d = 1; d < input[k].length; ++k) {
                int date = input[k][d];
                if (map.containsKey(date)) {
                    map.put(date, map.get(date) + 1);
                } else {
                    map.put(date, 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= t) {
                return entry.getKey();
            }
        }
        map.values().toArray();
        List<Object> list = null;
//        Collections.sort(Arrays.asList(map.values().toArray()));
        return -1;

    }
}
