package BackTrack;

import java.util.Collections;
import java.util.List;
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

    /**
     * 考虑一个空数组，用原数组填充新数组，每种填充方式对应一个解outPut
     * pos代表当前需要填充的位置，pos之前的位置已经填充好
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> outPut = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            outPut.add(nums[i]);
        }
        //从pos=0开始填充数组，枚举各种可能的方式
        track(outPut, 0, resList);
        return resList;
    }

    private void track(List<Integer> outPut, int pos, List<List<Integer>> resList) {
        //已经填充到最后，需要返回，把这个解存入解集中
        if (pos == outPut.size()) {
            resList.add(new ArrayList(outPut));
            return;
        }
        for (int i = pos; i < outPut.size(); ++i) {
            //将原数组位置i的元素填入pos位置中
            Collections.swap(outPut, pos, i);
            //递归
            track(outPut, pos+1, resList);
            //这里必须要恢复，因为上层循环的父递归调用需要用到原来顺序的outPut，注意所有循环递归调用都是用outPut
            Collections.swap(outPut, pos, i);
        }
    }
}
