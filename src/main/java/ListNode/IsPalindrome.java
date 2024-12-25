package ListNode;

public class IsPalindrome {

    /**
     * 是否为回文链表：反转前一半的链表，再遍历前后两半即可
     * 先获取链表长度，注意奇偶两种情况考虑
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            ++size;
            cur = cur.next;
        }
        cur = head;
        ListNode prev = null;
        ListNode next = null;
        int half = size / 2 + size % 2;
        for (int i = 0; i < half; ++i) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode leftHalf = prev;
        if (size % 2 == 1) {
            leftHalf = prev.next;
        }
        ListNode rightHalf = cur;
        while (leftHalf != null && rightHalf != null) {
            if (leftHalf.val != rightHalf.val) {
                return false;
            }
            leftHalf = leftHalf.next;
            rightHalf = rightHalf.next;
        }
        return true;
    }
}
