package ListNode;

public class ReverseListNode {

    /**
     * 反转链表，迭代法求解，O(1)内存，O(N)时间复杂度
     * 如不限制O(1)内存，可以自然的想到用栈求解
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        // write code here
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            //注意第一个节点的next指针需要修改为null
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;

        ReverseListNode solution = new ReverseListNode();
        ListNode ans = solution.ReverseList(n1);
        System.out.println(ans.val);
    }

}
