package com.stark._101_200._111_120;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/10/27.
 * 给定一个排序链表，删除所有重复的元素只留下原链表中没有重复的元素。
 */
public class LintCode_113 {
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        ListNode pre = res;
        int val = head.val;
        ListNode next = head.next;
        boolean repeat = false;
        while (next != null) {
            if (next.val == val) {
                repeat = true;
            } else {
                if (!repeat) {
                    pre.next = new ListNode(val);
                    pre = pre.next;
                }
                val = next.val;
                repeat = false;
            }
            next = next.next;
        }
        if (!repeat) {
            pre.next = new ListNode(val);
        }
        return res.next;
    }
}
