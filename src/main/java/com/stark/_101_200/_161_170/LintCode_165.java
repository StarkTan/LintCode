package com.stark._101_200._161_170;

import com.stark._1_100._1_10.LintCode_1;
import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/10/13.
 * 将两个排序链表合并为一个新的排序链表
 */
public class LintCode_165 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode res = new ListNode(0);
        ListNode pre = res;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int v1 = l1.val;
                int v2 = l2.val;
                if (v1 > v2) {
                    ListNode next = l2;
                    l2 = l2.next;
                    pre.next = next;
                } else {
                    ListNode next = l1;
                    l1 = l1.next;
                    pre.next = next;
                }
                pre = pre.next;
            } else if (l1 != null) {
                pre.next = l1;
                l1 = null;
            } else {
                pre.next = l2;
                l2 = null;
            }
        }
        return res.next;
    }
}
