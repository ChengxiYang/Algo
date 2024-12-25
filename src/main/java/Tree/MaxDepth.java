package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxDepth {

    private int deep = 0;

    /**
     * 维护一个路径栈，栈的最大深度即为树高
     * 官方题解是利用树高的递归定义：root_depth = max(left_depth, right_depth) + 1
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> pathStack = new ArrayDeque<>();
        inorder(root, pathStack);
        return deep;
    }

    private void inorder(TreeNode root, Deque<TreeNode> path) {
        deep = Math.max(path.size(), deep);
        if (root == null) {
            return;
        }
        path.addLast(root);
        inorder(root.left, path);
        inorder(root.right, path);
        path.removeLast();
    }
}
