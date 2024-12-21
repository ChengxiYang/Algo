package Tree;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
 */
public class Flatten {

    private List<TreeNode> list = new ArrayList<>();

    /**
     * 将前序遍历的结果保存在list中
     * 不要在前序遍历时修改节点左右子节点指向, 否则会破坏树的结构
     */
    public void flatten(TreeNode root) {
        dfs(root);
        for (int i = 0; i < list.size() - 1; ++i) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i+1);
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
