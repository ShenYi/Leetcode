import model.ListNode;

/**
 * https://oj.leetcode.com/problems/sort-list/
 * 
 * @author yishen
 * 
 */
public class SortList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SortList instance = new SortList();
        ListNode node = ListNode.con(new int[]
        {1, 3, 3, 1, 3, 1, 3, 3, 2, 3, 2, 2, 1, 1, 1, 3, 2, 2, 1, 1, 2, 2, 2, 3, 3, 1, 1, 2, 2, 2, 1, 2, 1, 1, 2, 3, 3, 2, 2, 3, 2, 3, 2, 2, 2, 1, 1,
                3, 2, 3, 3, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 3, 1, 3, 1, 1, 1, 2, 1, 2, 2,
                2, 1, 3, 2, 2, 2, 3, 3, 2, 3, 3, 1, 1, 2, 2, 1, 2, 1, 3, 2, 1, 3, 3, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 3, 3, 3, 1, 1, 3, 2, 1,
                1, 2, 1, 3, 3, 2, 2, 1, 3, 1, 3, 1, 3, 2, 2, 3, 2, 3, 2, 2, 1, 2, 3, 1, 3,
                1, 2, 3, 3, 2, 3, 3, 3, 1, 1, 2, 3, 1, 2, 3, 2, 1, 1, 2, 3, 1, 1, 3, 1, 2, 2, 3, 2, 1, 3, 1, 2, 1, 3, 2, 1, 1, 2, 2, 2, 1, 3, 1, 3,
                2, 3, 3, 1, 1, 3, 1, 2, 1, 2, 3, 1, 2, 1, 1, 3, 1, 3, 3, 1, 1, 1, 2, 2, 1,
                3, 1, 2, 2, 3, 2, 1, 3, 2, 1, 3, 2, 2, 3, 3, 2, 2, 1, 3, 2, 2, 2, 2, 2, 3, 2, 2, 3, 1, 3, 2, 1, 3, 2, 1, 2, 3, 3, 3, 1, 2, 2, 3, 1,
                1, 2, 2, 3, 2, 1, 1, 1, 1, 1, 3, 2, 2, 2, 1, 3, 2, 1, 2, 3, 2, 1, 1, 2, 1,
                3, 3, 1, 3, 1, 2, 2, 1, 2, 3, 2, 3, 3, 1, 2, 3, 2, 2, 3, 3, 2, 1, 3, 2, 2, 2, 3, 3, 3, 1, 1, 2, 1, 1, 2, 3, 3, 3, 1, 3, 2, 2, 1, 2,
                2, 1, 2, 3, 1, 3, 2, 2, 3, 3, 3, 1, 2, 3, 2, 1, 3, 1, 1, 2, 2, 1, 1, 1, 2,
                2, 3, 1, 3, 1, 2, 3, 3, 3, 2, 2, 3, 1, 1, 1, 3, 2, 1, 1, 3, 1, 2, 3, 3, 3, 2, 1, 2, 3, 2, 3, 2, 1, 3, 2, 2, 2, 2, 1, 1, 3, 1, 1, 1,
                3, 2, 2, 2, 1, 2, 3, 2, 3, 2, 2, 1, 2, 3, 2, 1, 1, 3, 1, 3, 3, 1, 1, 1, 1,
                1, 2, 3, 3, 3, 1, 3, 2, 2, 3, 1, 1, 3, 1, 1, 1, 3, 1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1, 3, 3, 3, 1, 2, 2, 2, 2, 3, 3, 1, 2, 2, 3, 1, 3,
                1, 2, 1, 2, 2, 3, 3, 1, 3, 3, 2, 1, 3, 1, 1, 3, 1, 2, 3, 3, 3, 3, 1, 1, 3,
                3, 3, 3, 2, 2, 2, 1, 1, 3, 2, 2, 2, 3, 1, 3, 3, 3, 1, 1, 3, 1, 3, 2, 3, 1, 2, 3, 2, 2, 3, 3, 3, 1, 2, 1, 2, 1, 2, 3, 1, 2, 2, 2, 1,
                1, 1, 2, 2, 1, 2, 1, 1, 1, 3, 2, 1, 2, 3, 2, 2, 2, 1, 2, 3, 2, 2, 1, 3, 3,
                3, 1, 2, 3, 3, 1, 1, 3, 3, 1, 1, 2, 1, 2, 3, 1, 2, 3, 2, 2, 3, 2, 1, 3, 1, 3, 1, 2, 2, 2, 2, 1, 2, 3, 3, 2, 2, 2, 3, 2, 2, 1, 2, 2,
                3, 1, 3, 1, 1, 1, 2, 3, 3, 2, 2, 3, 3, 2, 3, 1, 1, 2, 2, 2, 3, 2, 2, 1, 1,
                3, 2, 2, 3, 3, 3, 3, 1, 2, 3, 3, 1, 3, 3, 1, 2, 2, 1, 3, 2, 3, 3, 2, 3, 2, 1, 2, 1, 2, 2, 3, 3, 2, 3, 3, 1, 1, 2, 1, 3, 2, 2, 3, 1,
                2, 1, 3, 1, 1, 3, 3, 3, 3, 2, 3, 3, 3, 1, 3, 2, 2, 2, 3, 3, 1, 2, 1, 2, 3,
                2, 2, 2, 2, 3, 3, 1, 1, 3, 3, 2, 1, 3, 2, 2, 3, 2, 3, 2, 2, 2, 3, 1, 2, 1, 3, 2, 2, 1, 2, 2, 3, 2, 2, 2, 2, 2, 1, 1, 2, 1, 3, 3, 2,
                2, 2, 1, 3, 3, 3, 3, 2, 3, 3, 2, 3, 3, 1, 3, 3, 1, 3, 2, 2, 2, 2, 2, 1, 2,
                2, 3, 3, 3, 1, 2, 3, 1, 3, 2, 2, 2, 2, 3, 1, 1, 1, 3, 2, 3, 3, 2, 3, 1, 2, 1, 2, 2, 1, 2, 2, 3, 3, 1, 2, 3, 2, 2, 3, 3, 1, 1, 1, 2,
                1, 2, 3, 3, 2, 2, 2, 2, 3, 1, 1, 1, 3, 3, 1, 1, 1, 3, 3, 3, 2, 3, 3, 1, 1,
                1, 2, 3, 2, 2, 2, 2, 1, 2, 2, 3, 1, 3, 1, 2, 3, 1, 3, 3, 1, 2, 3, 2, 2, 3, 3, 1, 1, 2, 1, 2, 3, 3, 3, 2, 1, 2, 1, 2, 3, 1, 2, 2, 1,
                2, 2, 2, 1, 2, 3, 3, 3, 3, 1, 2, 1, 3, 1, 1, 2, 1, 3, 1, 3, 2, 3, 2, 3, 3,
                1, 2, 2, 2, 3, 3, 2, 1, 1, 3, 1, 2, 1, 3, 1, 2, 1, 2, 2, 2, 1, 3, 1, 1, 2, 2, 1, 2, 1, 2, 3, 3, 1, 1, 3, 1, 1, 1, 2, 2, 3, 1, 3, 3,
                3, 3, 2, 2, 1, 3, 2, 3, 2, 2, 1, 3, 3, 2, 1, 2, 1, 2, 2, 3, 1, 2, 2, 1, 2,
                2, 3, 1, 3, 3, 2, 3, 1, 1, 1, 3, 3, 3, 3, 3, 3, 1, 1, 1, 3, 3, 2, 2, 1, 1, 3, 2, 2, 2, 3, 3, 3, 1, 2, 2, 1, 1, 3, 3, 3, 2, 2, 2, 2,
                3, 1, 2, 1, 2, 2, 3, 3, 3, 2, 2, 2, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 2, 3,
                1, 3, 1, 1, 3, 1, 2, 1, 3, 2, 2, 3, 1, 2, 3, 3, 2, 2, 1, 1, 2, 2, 2, 2, 1, 3, 1, 3, 3, 3, 3, 3, 3, 3, 1, 3, 3, 2, 1, 1, 2, 2, 1, 2,
                3, 2, 3, 1, 3, 1, 1, 3, 2, 1, 2, 1, 2, 2, 3, 1, 2, 1, 3, 2, 1, 3, 2, 3,
                3, 2, 3, 3, 1, 3, 2, 2, 1, 3, 2, 2, 3, 2, 2, 2, 1, 2, 3, 2, 3, 3, 3, 2, 3, 1, 3, 3, 1, 3, 3, 3, 3, 1, 2, 2, 2, 1, 3, 3, 3, 2, 3, 1,
                1, 2, 3, 3, 3, 1, 3, 3, 1, 2, 3, 1, 3, 1, 3, 2, 1, 1, 3, 3, 3, 2, 2, 3, 3});

        instance.output(node);
        ListNode a = instance.mergeSort(node);
        instance.output(a);

    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /* find the mid node */
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        slow.next = null;

        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(next);

        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
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

        p.next = (p1 == null) ? p2 : p1;

        return head.next;
    }

    @SuppressWarnings("unused")
    public static ListNode con(int[] a) {
        ListNode next = null;
        for (int i = a.length - 1; i >= 0; i--) {
            ListNode b = new ListNode(a[i]);
            b.next = next;
            next = b;
        }
        return next;
    }

    public void output(ListNode node) {
        ListNode p = node;
        while (p != null) {
            System.out.print(" " + p.val);
            p = p.next;
        }
        System.out.println();
    }

    @SuppressWarnings("unused")
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return sort(head, null);
    }

    public ListNode sort(ListNode start, ListNode end) {
        if (start == end) {
            return start;
        }

        ListNode leftPart = start;

        ListNode p = start;
        while (p.next != null) {
            if (p.next.val < start.val) {
                // move to left
                ListNode current = p.next;
                p.next = p.next.next;
                current.next = leftPart;
                leftPart = current;
            } else {
                p = p.next;
            }
        }

        ListNode newHead = sort(leftPart, start);
        start.next = sort(start.next, end);

        return newHead;
    }

}
