package Tree;

import Util.TreeNode;

/**
 * @author chengxiyang
 */
public class InvertTree {

    /**
     * 二叉树翻转，不要想子节点值交换逻辑，而是子节点指针交换逻辑
     * 沿用子节点指针交换逻辑，很容易想到翻转的递归性质
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
