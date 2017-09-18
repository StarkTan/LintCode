package com.stark._101_200._161_170;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/9/17.
 * 给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数
 */
public class LintCode_170 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0 || head.next == null) {
            return head;
        }
        ListNode end = head;
        ListNode begin = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
            if (end == null) {
                end = head;
            }
        }
        while (end.next != null) {
            end = end.next;
            begin = begin.next;
            if (end == null) {
                end = head;
            }
            if (begin == null) {
                begin = head;
            }

        }
        end.next = head;
        head = begin.next;
        begin.next = null;
        return head;
    }
}
