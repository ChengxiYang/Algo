package Tree;

import Util.TreeNode;

import java.util.*;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 * 链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree
 */
public class FindMode {

    private List<Integer> ans = new ArrayList<>();
    private int last = 0, count = 0, maxCount = 0;

    /**
     * 中序遍历，同时维护当前节点出现的次数、已遍历节点出现最大次数（非递减数组最多元素个数可以不用hashmap统计）
     */
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ans_ = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) {
            ans_[i] = ans.get(i);
        }
        return ans_;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        countNum(node.val);
        dfs(node.right);
    }

    private void countNum(int cur) {
        if (cur == last) {
            ++count;
        } else {
            count = 1;
            last = cur;
        }
        if (count == maxCount) {
            ans.add(cur);
        }
        if (count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(cur);
        }
    }

    /**
     * 广度优先遍历 + hashmap统计各数出现的次序
     */
    public int[] findMode_(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxFre = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (map.containsKey(cur.val)) {
                map.put(cur.val, map.get(cur.val) + 1);
                if (map.get(cur.val) > maxFre) {
                    maxFre = map.get(cur.val);
                }
            } else {
                map.put(cur.val, 1);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) == maxFre) {
                list.add(key);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
