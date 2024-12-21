package Tree;

import Util.TreeNode;

public class DiameterOfBinaryTree {

    private int ans = -1;

    public int diameterOfBinaryTree(TreeNode root) {

        depth(root);
        return ans - 1;
    }

    /**
     * 在递归遍历各个节点时更新目前的直径
     * @param node 根节点
     * @return 深度，从根节点开始经过的节点数目
     */
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
