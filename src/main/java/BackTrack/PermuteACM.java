package BackTrack;

import java.util.LinkedList;

public class PermuteACM {

    static int len;

    public static void main(String[] args) {
        len = 8;
        LinkedList<Integer> ans = new LinkedList<>();
        generate(ans);
    }

    public static void generate(LinkedList<Integer> ans) {
        if (ans.size() == len) {
            StringBuilder out = new StringBuilder();
            for (int i : ans) {
                out.append(i).append(" ");
            }
            System.out.println(out.toString().trim());
            return;
        }
        //for循环中递归 & 回溯
        for (int i = 1; i <= len; ++i) {
            if (ans.contains(i)) {
                continue;
            }
            ans.add(i);
            generate(ans);
            ans.removeLast();
        }
    }
}
