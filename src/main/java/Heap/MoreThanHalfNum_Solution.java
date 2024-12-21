package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum_Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 利用Map1记录数组中每个元素出现的次数
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int MoreThanHalfNum_MapSolution (int[] numbers) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i) {
            if (map.containsKey(numbers[i])) {
                map.put(numbers[i], map.get(numbers[i]) + 1);
            } else {
                map.put(numbers[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > numbers.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
        // write code here
    }

    public int MoreThanHalfNum_SortSolution (int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length / 2];
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,2,2,2,5,4,2};
        MoreThanHalfNum_Solution mapSolution = new MoreThanHalfNum_Solution();
        mapSolution.MoreThanHalfNum_MapSolution(test);
    }
}
