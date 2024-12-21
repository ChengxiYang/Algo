package Tree;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class PostorderTraversal {

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        post(root);
        return ans;
    }

    private void post(TreeNode node) {
        if (node == null) {
            return;
        }
        post(node.left);
        post(node.right);
        ans.add(node.val);
    }
}
