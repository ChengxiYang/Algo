package Tree;

import Util.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数
 */
public class KthSmallest {

    private int cnt = 0;

    private int k;

    private int ans;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        ++cnt;
        if (cnt == k) {
            ans = node.val;
        }
        dfs(node.right);
    }
}
