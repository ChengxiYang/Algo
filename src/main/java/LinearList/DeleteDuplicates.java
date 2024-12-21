package LinearList;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 */
public class DeleteDuplicates {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && cur.val == next.val) {
                ListNode nnext = next.next;
                cur.next = nnext;
                next.next = null;
            } else {
                cur = next;
            }
        }
        return head;
    }
}
