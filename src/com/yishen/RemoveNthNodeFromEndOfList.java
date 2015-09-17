package com.yishen;

import com.yishen.model.ListNode;

/**
 * Created by yishen on 15/7/18.
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        new RemoveNthNodeFromEndOfList().removeNthFromEnd(
                ListNode.create(new int[]{1}),
                5
        ).print();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode p2 = new ListNode(-1);
        p2.next = head;

        int i = 0;
        while (i++ < n) {
            p = p.next;
        }
        if (p == null) {
            return head.next;
        }

        while (p != null) {
            p = p.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return head;
    }
}
