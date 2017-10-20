package com.stark._101_200._161_170;

import com.stark.entity.ListNode;

import java.util.List;

/**
 * Created by Stark on 2017/10/20.
 * 找到单链表倒数第n个节点，保证链表中节点的最少数量为n。
 */
public class LintCode_166 {
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        int num = 0;
        ListNode pre = new ListNode(0);
        pre.next=head;
        ListNode first = pre;
        ListNode second = pre;
        while (num<n){
            first = first.next;
            num++;
        }
        while (first!=null){
            first =first.next;
            second = second.next;
        }
        return  second;
    }
}
