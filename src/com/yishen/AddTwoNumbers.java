package com.yishen;

import com.yishen.model.ListNode;

/**
 * Created by yishen on 15/7/11.
 * https://leetcode.com/problems/add-two-numbers/
 * Error1: missing carry at final
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        new AddTwoNumbers().addTwoNumbers(
                        ListNode.create(new int[] {2, 4, 3}),
                        ListNode.create(new int[] {5, 6, 4})).print();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(-1);

        int carry = 0;
        ListNode head = sum;
        sum.next = head;
        while (l1 != null && l2 != null) {
            int s = l1.val + l2.val + carry;
            carry = s / 10;
            s = s % 10;
            head.next = new ListNode(s);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int s = l1.val + carry;
            carry = s / 10;
            s = s % 10;
            head.next = new ListNode(s);
            head = head.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int s = l2.val + carry;
            carry = s / 10;
            s = s % 10;
            head.next = new ListNode(s);
            head = head.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            head.next = new ListNode(carry);
        }

        return sum.next;
    }
}
