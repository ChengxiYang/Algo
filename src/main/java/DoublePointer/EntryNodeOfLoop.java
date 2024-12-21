package DoublePointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 求解链表是否有环
 */
public class EntryNodeOfLoop {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }



    /**
     * 利用Set保存遍历过的节点，第一个重复元素即为环入口
     */
    public ListNode EntryNodeOfLoopSet(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = pHead;
        while (cur != null && !set.contains(cur)) {
            set.add(cur);
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 利用快慢指针技巧找到环节点
     * 注意：头节点到环节点入口与相遇节点到环节点入口距离相等！
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        do {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
                break;
            }

        } while (slow != null && fast != null && fast != slow);

        if (fast == null) {
            return null;
        }
        ListNode i = fast;
        ListNode j = pHead;
        while(i != j) {
            i = i.next;
            j = j.next;
        }
        return i;
    }
}
