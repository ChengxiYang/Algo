package Tree;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengxiyang
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        if (root.left == null && root.right == null) {
            ret.add(root.val + "");
            return ret;
        }
        String tmp = root.val + "->";
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for (String s : left) {
            ret.add(tmp + s);
        }
        for (String s : right) {
            ret.add(tmp + s);
        }
        return ret;
    }
}
