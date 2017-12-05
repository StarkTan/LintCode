package com.stark._101_200._171_180;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/12/5.
 * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。
 */
public class LintCode_174 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (n == 0) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre;
        ListNode q = pre;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return pre.next;
    }
}
