import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chengxiyang
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> mapB = new HashMap<>();
        int j = 0;

        for (ListNode b = headB; b != null; b = b.next) {
            mapB.put(b, j);
            ++j;
        }
        for (ListNode a = headA; a != null; a = a.next) {
            if (mapB.containsKey(a)) {
                return a;
            }
        }
        Set<Integer> set = new HashSet<>();
        return null;
    }

     static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
}
