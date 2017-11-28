package com.stark._401_500._451_460;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/11/28.
 * 删除链表中等于给定值val的所有节点。
 */
public class LintCode_452 {

    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        ListNode preRes = new ListNode(0);
        ListNode pre = preRes;
        pre.next = head;
        while (pre.next != null) {
            ListNode cur = pre.next;
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
        }
        return preRes.next;
    }
}
