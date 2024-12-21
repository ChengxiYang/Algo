package Tree;

import Util.TreeNode;

/**
 * note: 中序遍历二叉搜索树得到的关键码序列是一个递增序列
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * 0 <= Node.val <= 105
 */
public class GetMinimumDifference {

    private int pre = -1;

    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        //这里巧妙地用了类成员变量，在递归过程中不断修改，保证作用域可见性
        dfs(root);
        return min;


    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        //第一个遍历节点的标记
        if (pre == -1) {
            pre = node.val;
        } else {
            min = Math.min(min, node.val - pre);
            //更新pre值
            pre = node.val;
        }
        dfs(node.right);
    }
}
