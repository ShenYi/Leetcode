package com.yishen;

import com.yishen.model.ListNode;

/**
 * Created by yishen on 15/7/19.
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode l1 = ListNode.create(new int[]{1, 3, 5});
        ListNode l2 = ListNode.create(new int[]{2, 4, 6});
        new MergeTwoSortedList().mergeTwoLists(l1, l2
        ).print();
        l1.print();
        l2.print();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }
}

