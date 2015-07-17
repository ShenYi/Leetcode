package com.yishen.model;

/**
 * Created by yishen on 15/7/11.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print() {
        ListNode l = this;
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.println();
    }

    public static ListNode create(int[] a) {
        ListNode head = new ListNode(-1);
        ListNode l = head;
        for (int i = 0; i < a.length; i++) {
            l.next = new ListNode(a[i]);
            l = l.next;
        }
        return head.next;
    }
}
