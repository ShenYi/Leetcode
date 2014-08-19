import model.ListNode;

/**
 * http://oj.leetcode.com/submissions/detail/6593340/
 * 
 * @author yishen
 *
 */
public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode a = ListNode.con(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5});
        ListNode p = deleteDuplicates(a);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode virtualHead = new ListNode(-1);
        virtualHead.next = head;

        ListNode pre = virtualHead;
        ListNode cur = head;
        int curCount = 1;

        while (true) {
            ListNode next = cur.next;
            if (next != null && next.val == cur.val) {
                curCount++;
                cur = next;
            } else {
                if (curCount > 1) {
                    pre.next = next;
                } else {
                    pre = cur;
                }
                if (next == null) {
                    return virtualHead.next;
                }
                cur = next;
                curCount = 1;
            }
        }
    }
}
