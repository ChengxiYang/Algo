package Tree;

import Util.TreeNode;

import java.util.Stack;

/**
 * @author chengxiyang
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> unvisited = new Stack<>();
        Stack<TreeNode> visited= new Stack<>();
        int sum = 0;
        TreeNode cur = root;
        unvisited.push(cur);
        while (!unvisited.isEmpty()) {
            cur = unvisited.pop();
            visited.push(cur);
            sum += cur.val;
            if (cur.right != null) {
                unvisited.push(cur.right);
            }
            if (cur.left != null) {
                unvisited.push(cur.left);
            }
            if (cur.left == null && cur.right == null) {
                if (sum == targetSum) {
                    return true;
                }
                if (unvisited.isEmpty()) {
                    return false;
                }
                TreeNode nextVisit = unvisited.peek();
                while (true) {
                    TreeNode tmp = visited.pop();
                    sum -= tmp.val;
                    if (tmp.right == nextVisit) {
                        visited.push(tmp);
                        sum += tmp.val;
                        break;
                    }
                }
            }
        }
        return false;
    }

    private int sum = 0;
    private int target;
    private boolean signal = false;

    /**
     * 递归 & 回溯技巧
     */
    public boolean hasPathSum_(TreeNode root, int targetSum) {
        if (root == null) {
            return signal;
        }
        this.target = targetSum;
        dfs(root);
        return signal;
    }

    private void dfs(TreeNode root) {
        sum += root.val;

        if (root.left == null && root.right == null && sum == target) {
            signal = true;
            return;
        }

        if (root.left != null) {
            dfs(root.left);
            sum -= root.left.val;
        }

        if (root.right != null) {
            dfs(root.right);
            sum -= root.right.val;
        }
        return;
    }
}
