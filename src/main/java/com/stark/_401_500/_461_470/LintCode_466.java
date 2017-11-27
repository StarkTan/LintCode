package com.stark._401_500._461_470;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/11/24.
 * 计算链表中有多少个节点.
 */
public class LintCode_466 {
    public int countNodes(ListNode head) {
        // write your code here
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}
