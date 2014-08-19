import model.ListNode;

/**
 * http://oj.leetcode.com/problems/linked-list-cycle-ii/
 * 
 * @author yishen
 * 
 */
public class DefectCycle {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
            if (b != null) {
                b = b.next;
            }
            if (a == b && a != null) {
                // we have found circle
                a = head;
                for (; a != b;) {
                    a = a.next;
                    b = b.next;
                }
                return a;
            }
        }

        return null;
    }

}
