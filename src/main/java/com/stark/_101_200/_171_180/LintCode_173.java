package com.stark._101_200._171_180;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/10/10.
 * 用插入排序对链表排序
 */
public class LintCode_173 {
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        ListNode befHead = new ListNode(0);
        befHead.next = head;
        ListNode pre = befHead;
        while (pre.next != null) {
            ListNode preMin = pre;
            ListNode min = pre.next;
            ListNode begin = min;
            while (begin.next != null) {
                if (begin.next.val < min.val) {
                    preMin = begin;
                    min = preMin.next;
                }
                begin = begin.next;
            }
            if (min != pre.next) {
                preMin.next = min.next;
                min.next = pre.next;
                pre.next = min;
            }
            pre = pre.next;
        }
        return befHead.next;
    }
}
