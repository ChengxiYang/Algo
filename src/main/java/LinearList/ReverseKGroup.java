package LinearList;

import java.util.ArrayDeque;

/**
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
 */
public class ReverseKGroup {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    /**
     *用一个栈来辅助，栈中元素个数限制为k。
     *从头节点开始顺序遍历输入链表，将元素依次压入栈中，同时判断栈中元素个数，如果达到k，则将栈中所有节点依次弹出，依次连接所有出栈节点，即可得到目标结果
     *最后处理边界情况: 栈中剩余的节点个数是否等于k, 如果等于, 按队列处理；小于，按栈处理
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode ret = null;
        ListNode prev = null;
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    if (ret == null) {
                        ret = stack.pollLast();
                        prev = ret;
                    } else {
                        prev.next = stack.pollLast();
                        prev = prev.next;
                    }
                }
            }
            stack.offerLast(cur);
        }
        if (stack.size() < k) {
            while (!stack.isEmpty()) {
                //如果k >= size, 则prev为空
                if (prev == null) {
                    ret = stack.pollFirst();
                    prev = ret;
                } else {
                    prev.next = stack.pollFirst();
                    prev = prev.next;
                }
            }
        } else {
            while (!stack.isEmpty()) {
                if (prev == null) {
                    ret = stack.pollLast();
                    prev = ret;
                } else {
                    prev.next = stack.pollLast();
                    prev = prev.next;
                }
            }
        }
        prev.next = null;
        return ret;
    }
}
