package com.stark.entity;

/**
 * Created by Stark on 2017/10/19.
 * 双向链表
 */
public class DoublyListNode {
    int val;
    public DoublyListNode next, prev;

    public DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}
