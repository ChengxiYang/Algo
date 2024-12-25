package Tree;

import java.util.*;

public class LevelOrder {

    /**
     * 这里使用两个队列来维护层序信息
     * 也可以通过单个队列元素个数来做
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue1 = new ArrayDeque<>();
        Deque<TreeNode> queue2 = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        queue1.addLast(root);
        while (!queue1.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode cur = queue1.removeFirst();
                level.add(cur.val);
                if (cur.left != null) {
                    queue2.add(cur.left);
                }
                if (cur.right != null) {
                    queue2.add(cur.right);
                }
            }
            ans.add(level);
            Deque<TreeNode> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        return ans;

    }

    /**
     * 层次遍历优化版本
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderOpt(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.removeFirst();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
            ans.add(level);
        }
        return ans;

    }
}
