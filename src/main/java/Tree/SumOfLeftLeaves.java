package Tree;

import Util.TreeNode;

/**
 * @author chengxiyang
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumL(root, root.left) + sumL(root, root.right);
    }

    private int sumL(TreeNode p, TreeNode c) {
        int ret = 0;
        if (p == null || c == null) {
            return ret;
        }
        if (c.left == null && c.right == null) {
            if (p.left == c) {
                ret += c.val;
                return ret;
            }
            if (p.right == c) {
                return ret;
            }
        }
        int l = sumL(c, c.left);
        int r = sumL(c, c.right);
        return ret + l + r;
    }
}
