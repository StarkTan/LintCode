package com.stark._401_500._451_460;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/9/17.
 * 给一个链表，两两交换其中的节点，然后返回交换后的链表。
 */
public class LintCode_451 {
    public ListNode swapPairs(ListNode head) {
        ListNode one = head;
        if(one==null)return null;
        ListNode two = one.next;
        if(two==null)return one;
        ListNode next = two.next;
        two.next=one;
        one.next=swapPairs(next);
        return two;
    }
}
