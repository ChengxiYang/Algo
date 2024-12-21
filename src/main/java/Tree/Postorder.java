package Tree;

import java.util.ArrayList;
import java.util.List;

public class Postorder {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private List<Integer> list = new ArrayList<>();

    /**
     * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        visit(root);
        return list;
    }

    void visit(Node root) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            visit(node);
        }
        list.add(root.val);
    }
}
