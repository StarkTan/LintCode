package com.stark._501_600._511_520;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/10/9.
 * 给你一个链表以及两个权值v1和v2，交换链表中权值为v1和v2的这两个节点。
 * 保证链表中节点权值各不相同，如果没有找到对应节点，那么什么也不用做。
 */
public class LintCode_511 {
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode preOne = null;
        ListNode preTwo = null;

        ListNode search = start;

        while (search.next != null) {
            ListNode next = search.next;
            if (next.val == v1) {
                preOne = search;
            }
            if (next.val == v2) {
                preTwo = search;
            }
            search = next;
        }
        if (preOne == null || preTwo == null) {
            return start.next;
        }


        ListNode one = preOne.next;
        ListNode two = preTwo.next;
        if (two.next == one) {
            preTwo.next = one;
            two.next = one.next;
            one.next = two;
            return start.next;
        } else if (one.next == two) {
            preOne.next = two;
            one.next = two.next;
            two.next = one;
            return  start.next;
        }
        ListNode befone = preOne.next.next;
        ListNode beftwo = preTwo.next.next;
        one.next = beftwo;
        two.next = befone;
        preOne.next = two;
        preTwo.next = one;
        return start.next;
    }
}
