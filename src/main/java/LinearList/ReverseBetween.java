package LinearList;

public class ReverseBetween {
    /**
     *
     * @param head 链表头节点
     * @param m 起点
     * @param n 终点
     * @return 区间反转链表
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode a = null;
        ListNode b = null;
        ListNode c = null;
        ListNode d = null;
        int count = 1;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (count == m) {
                a = prev;
                b = cur;
            }
            ListNode tmp = cur.next;
            if (m < count && count <= n) {
                cur.next = prev;
                if (count == n) {
                    c = cur;
                    d = tmp;
                }
            }
            prev = cur;
            cur = tmp;
            ++count;
        }
        ListNode ret = head;
        if (m == 1) {
            ret = c;
            b.next = d;
        } else {
            a.next = c;
            b.next = d;
        }
        return ret;
    }

    public static class ListNode {
        public int val;
        public ListNode next = null;
    }
}
