import model.ListNode;

/**
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * 
 * @author yishen
 * 
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        while (p1 != null) {
            p.next = p1;
            p = p1;
            p1 = p1.next;
        }

        while (p2 != null) {
            p.next = p2;
            p = p2;
            p2 = p2.next;
        }

        return head.next;
    }
}
