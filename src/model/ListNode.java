package model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode con(int[] a) {
        ListNode next = null;
        for (int i = a.length - 1; i >= 0; i--) {
            ListNode b = new ListNode(a[i]);
            b.next = next;
            next = b;
        }
        return next;
    }
}
