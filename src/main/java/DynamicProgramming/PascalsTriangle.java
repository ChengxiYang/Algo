package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    /**
     * 生成杨辉三角, 状态转移方程: 利用第k行确定第k+1行，注意数组首尾边界条件
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);

        for (int i = 1; i < numRows; ++i) {
            List<Integer> tri = new ArrayList<>();
            List<Integer> trp = ans.get(i - 1);
            int size = trp.size();
            for (int j = 0; j < size; ++j) {
                int a = 0;
                int b = 0;
                if (j == 0) {
                    a = 0;
                    b = trp.get(j);
                }
                else {
                    a = trp.get(j-1);
                    b = trp.get(j);
                }
                tri.add(a + b);
            }
            tri.add(trp.get(size - 1));
            ans.add(tri);
        }
        return ans;
    }
}
