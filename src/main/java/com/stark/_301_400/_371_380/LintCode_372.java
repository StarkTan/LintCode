package com.stark._301_400._371_380;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/12/8.
 * 给定一个单链表中的一个等待被删除的节点(非表头或表尾)。请在在O(1)时间复杂度删除该链表节点。
 */
public class LintCode_372 {

    public void deleteNode(ListNode node) {
        // write your code here
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
