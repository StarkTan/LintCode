package com.stark._1_100._91_100;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/10/9.
 * 给定一个单链表L: L0→L1→…→Ln-1→Ln,
 * 重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 必须在不改变节点值的情况下进行原地操作。
 * 给出链表 1->2->3->4->null，重新排列后为1->4->2->3->null。
 */
public class LintCode_99 {
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null) return;
        ListNode newHead = head.next;
        head.next = null;
        ListNode preNode = head;
        while (newHead != null) {
            if (newHead.next != null) {
                ListNode pre = newHead;
                ListNode last = newHead.next;
                while (last.next != null) {
                    last = last.next;
                    pre = pre.next;
                }
                preNode.next = last;
                preNode = preNode.next;
                pre.next = null;
            } else {
                preNode.next = newHead;
                preNode = preNode.next;
                newHead = null;
            }

            if (newHead != null) {
                preNode.next = newHead;
                preNode = preNode.next;
                newHead = newHead.next;
                preNode.next = null;
            }
        }

    }
}
