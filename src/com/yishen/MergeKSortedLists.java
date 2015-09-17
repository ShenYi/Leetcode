package com.yishen;

import com.yishen.model.ListNode;

import java.util.Stack;

/**
 * Created by yishen on 15/7/28.
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public static void main(String[] args) {


    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();

        for (int i = 0; i < lists.length; i++) {
            s1.push(lists[i]);
        }

        while (true) {
            if(s1.size() == 1) {
                return s1.pop();
            }

            while(!s1.isEmpty()) {
                ListNode p1 = s1.pop();
                if(s1.isEmpty()) {
                    s2.push(p1);
                } else {
                    ListNode p2 = s1.pop();
                    s2.push(mergeTwoLists(p1, p2));
                }
            }

            Stack<ListNode> temp = s1;
            s1 = s2;
            s2 = temp;
        }
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
