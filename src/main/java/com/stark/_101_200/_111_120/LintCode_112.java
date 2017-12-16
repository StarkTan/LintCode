package com.stark._101_200._111_120;

import com.stark.entity.ListNode;


/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_112 {
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) return null;
        int cur = head.val;
        ListNode pre = head;
        while (pre.next != null) {
            ListNode node = pre.next;
            if (cur == node.val) {
                pre.next = node.next;
                node.next = null;
            } else {
                cur = node.val;
                pre = node;
            }
        }
        return head;
    }
}
