package com.yishen;

import com.yishen.model.ListNode;

/**
 * Created by yishen on 15/7/28.
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        new SwapNodesInPairs().swapPairs(ListNode.create(new int[]{1})).print();
    }

    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(-1);
        ListNode p = result;
        while (head != null) {
            ListNode next = head.next;
            if (next == null) {
                p.next = head;
                break;
            } else {
                p.next = next;
                head.next = next.next;
                next.next = head;
                p = head;
                head = head.next;
            }
        }
        return result.next;
    }
}
