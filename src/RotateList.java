import model.ListNode;

/**
 * http://oj.leetcode.com/submissions/detail/6566086/
 * 
 * @author yishen
 * 
 */
public class RotateList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode p = ListNode.con(new int[] {1, 2, 3, 4, 5});
        p = rotateRight(p, 5);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }

    public static ListNode rotateRight(ListNode head, int n) {
        // find the length of the linked list
        if (head == null || n <= 0) {
            return head;
        }

        int i = 1;
        ListNode a = head;

        while (a.next != null) {
            i++;
            a = a.next;
        }
        // now a point to tail
        n = n % i;
        i = i - n;
        a.next = head;
        a = head;
        while (--i > 0) {
            a = a.next;
        }
        ListNode b = a.next;
        a.next = null;
        return b;
    }
}
