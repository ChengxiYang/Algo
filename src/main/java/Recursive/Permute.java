package Recursive;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 全排列问题的求解
 * 该问题相当于N皇后问题的简化版，缺少对角线约束条件
 * 需要一步步构造解并保存
 * 递归 + 回溯
 */
public class Permute {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        int len = num.length;
        boolean[][] maze = new boolean[len][len];
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                maze[i][j] = false;
            }
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        solve(maze, num, 0, ret, new ArrayList<>());
        return ret;
    }

    private void solve(boolean[][] maze,
                       int[] num,
                       int level,
                       ArrayList<ArrayList<Integer>> ret,
                       ArrayList<Integer> path) {

        int len = maze.length;
        if (level == len) {
            ret.add(path);
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (isValid(maze, level, i)) {
                maze[level][i] = true;
                ArrayList<Integer> newPath = new ArrayList<>();
                for (int p : path) {
                    newPath.add(p);
                }
                newPath.add(num[i]);
                solve(maze, num, level + 1, ret, newPath);
                maze[level][i] = false;
            }
        }
    }

    private boolean isValid(boolean[][] maze, int level, int k) {
        for (int i = 0; i < level; ++i) {
            if (maze[i][k] == true) {
                return false;
            }
        }
        return true;
    }

    /**
     * 一种更优雅高效的解法
     */
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    private void backTrack(int[] num, LinkedList<Integer> path) {
        if (path.size() == num.length) {
            //这里必须生成新的对象添加到结果中
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num.length; ++i) {
            if (path.contains(num[i])) {
                continue;
            }
            path.add(num[i]);
            backTrack(num, path);
            path.removeLast();
        }

    }
}
