package com.stark._1_100._31_40;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/9/14.
 * 翻转链表中第m个节点到第n个节点的部分
 * 1 ≤ m ≤ n ≤ 链表长度
 */
public class LintCode_36 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode before = null;
        ListNode after = null;
        ListNode scan = head;
        int pos = 1;
        while (null != scan) {
            if (pos == m - 1) {
                before = scan;
            }
            if (pos == n) {
                after = scan.next;
                scan.next = null;
            }
            pos++;
            scan = scan.next;
        }

        ListNode newList;
        if (before != null) {
            newList = before.next;
            before.next = null;
        } else {
            newList = head;
        }


        ListNode newHead = newList;
        ListNode next = newList.next;
        newHead.next=null;
        while (next != null) {
            ListNode newNext = next.next;
            next.next = newHead;
            newHead = next;
            next = newNext;
        }

        if (before == null) {
            newList.next = after;
            return newHead;
        }else {
            before.next=newHead;
            newList.next = after;
            return head;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next=new ListNode(4);
        head.next.next.next=new ListNode(5);
        head.next.next.next.next=new ListNode(6);
        ListNode reverse = new LintCode_36().reverseBetween(head, 2, 4);
        System.out.println(reverse);
    }
}
