package com.stark._1_100._31_40;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/9/14.
 *
 */
public class LintCode_35 {

    public ListNode reverse_V1(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode newHead = head;
        ListNode next = head.next;
        head.next=null;
        while (next != null) {
            ListNode newNext = next.next;
            next.next=newHead;
            newHead = next;
            next =newNext;
        }
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next=new ListNode(1);

        ListNode reverse = new LintCode_35().reverse_V1(head);
        System.out.println(reverse);
    }
}
