package Tree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 链接：https://leetcode.cn/problems/path-sum-ii
 */
public class PathSum {

    private final LinkedList<Integer> path = new LinkedList<>();

    private final List<List<Integer>> ret = new LinkedList<>();

    private int targetSum;

    private int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        if (root != null) {
            dfs(root);
        }
        return ret;
    }

    //递归 & 回溯
    //采用前序遍历得到从根节点到叶节点的所有路径
    //只对非空节点进行递归调用
    //递归终止条件: 叶节点
    //回溯: 递归返回时移除路径中最后一个节点
    private void dfs(TreeNode root) {

        path.addLast(root.val);
        sum += root.val;

        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                List<Integer> tmp = new LinkedList<>(path);
                ret.add(tmp);
            }
            return;
        }

        if (root.left != null) {
            dfs(root.left);
            sum -= path.removeLast();
        }

        if (root.right != null) {
            dfs(root.right);
            sum -= path.removeLast();
        }
        return;
    }
}
