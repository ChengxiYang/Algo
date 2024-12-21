package Tree;

import java.util.*;

public class LowestCommonAncestor {

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        List<Integer> pPath = findNode(root, p);
        List<Integer> qPath = findNode(root, q);
        int len = Math.min(qPath.size(), pPath.size());
        int i = 0;
        for (; i < len; ++i) {
            int x = pPath.get(i);
            int y = qPath.get(i);
            if (x != y) {
                break;
            }
            //比较数值大小不要用引用类型！会出现很难发现的bug
//            if (pPath.get(i) != qPath.get(i)) {
//                break;
//            }
        }

        return pPath.get(i - 1);

    }

    private List<Integer> findNode(TreeNode root, int n) {
        List<Integer> path = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            path.add(cur.val);
            if (cur.val == n) {
                break;
            }
            if (cur.val > n) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return path;
    }

    public int lowestCommonAncestor2 (TreeNode root, int o1, int o2) {
        // write code here
        Map<Integer, Integer> map = getParent(root);
        List<Integer> path1 = getPath(map, root, o1);
        List<Integer> path2 = getPath(map, root, o2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        int last = 0;
        while(i >= 0 && j >= 0) {
            int x = path1.get(i);
            int y = path2.get(j);
            if (x == y) {
                last = x;
                --i;
                --j;
            } else {
                break;
            }
        }
        return last;

    }

    private Map<Integer, Integer> getParent(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                map.put(cur.left.val, cur.val);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                map.put(cur.right.val, cur.val);
            }
        }
        return map;
    }

    private List<Integer> getPath(Map<Integer, Integer> map,
                                  TreeNode root,
                                  int n) {
        List<Integer> list = new ArrayList<>();
        int cur = n;
        while (cur != root.val) {
            list.add(cur);
            cur = map.get(cur);
        }
        list.add(cur);
        return list;
    }

     public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }
}
