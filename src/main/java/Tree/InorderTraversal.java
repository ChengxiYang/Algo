package Tree;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的中序遍历
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        visit(root, list);
        return list;

    }

    /**
     * 返回条件：null节点
     * list传引用
     */
    void visit(TreeNode cur, List<Integer> list) {

        if (cur == null) {
            return;
        }

        visit(cur.left, list);

        list.add(cur.val);

        visit(cur.right, list);

    }
}
