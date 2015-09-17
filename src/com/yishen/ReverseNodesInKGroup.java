package com.yishen;
import com.yishen.model.ListNode;

/**
 * Created by yishen on 15/8/31.
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        new ReverseNodesInKGroup().reverseKGroup(ListNode.create(new int[] {1,2,3,4,5}), 15).print();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l = new ListNode(-1);
        l.next = head;

        int i = 1;
        while (head != null && i < k) {
            i++;
            head = head.next;
        }

        if (head != null && i == k) {
            ListNode temp = head.next;
            head.next = null;
            ListNode newTail = l.next;
            l.next = reverseList(l.next);
            newTail.next = reverseKGroup(temp, k);
        }

        return l.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode q = null;
        ListNode s = null;
        while (p != null) {
            s = p.next;
            p.next = q;
            q = p;
            p = s;
        }
        return q;
    }
}
