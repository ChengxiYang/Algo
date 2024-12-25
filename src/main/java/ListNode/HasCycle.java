package ListNode;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = null;
        if (head == null || head.next == null) {
            return false;
        } else {
            fast = head.next.next;
        }

        while (slow != null && fast != null && fast != slow) {
            slow = slow.next;
            if (fast.next == null) {
                fast = null;
            } else {
                fast = fast.next.next;
            }
        }
        if (slow == null || fast == null) {
            return false;
        }
        return true;
    }
}
