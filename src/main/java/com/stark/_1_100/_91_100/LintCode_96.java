package com.stark._1_100._91_100;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/11/27.
 */
public class LintCode_96 {

    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode preBig = new ListNode(0);
        ListNode preSmall = new ListNode(0);
        ListNode res = preSmall;
        ListNode res1 = preBig;

        while (head != null) {
            if (head.val >= x) {
                preBig.next = head;
                preBig = head;
            } else {
                preSmall.next = head;
                preSmall = head;
            }
            head = head.next;
            preBig.next = null;
            preSmall.next = null;
        }
        preSmall.next = res1.next;
        return res.next;
    }
}
