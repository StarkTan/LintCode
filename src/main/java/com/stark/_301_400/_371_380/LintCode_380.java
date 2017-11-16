package com.stark._301_400._371_380;

import com.stark.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stark on 2017/11/16.
 * 请写一个程序，找到两个单链表最开始的交叉节点。
 * 注意事项
 * 如果两个链表没有交叉，返回null。
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环
 */
public class LintCode_380 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        while (headA != null) {
            set.add(headA.val);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB.val)) return headB;
            headB = headB.next;
        }
        return null;
    }

    //优解
    public ListNode getIntersectionNode_V2(ListNode headA, ListNode headB) {
        // write your code here
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int len1 = 0, len2 = 0;
        while (curA.next != null) { //链表1从头节点开始，走到最后一个节点
            len1++;           //链表1的长度
            curA = curA.next;
        }
        while (curB.next != null) {  //链表2从头节点开始，走到最后一个节点
            len2++;          //链表2的长度
            curB = curB.next;
        }
        if (curA != curB) {  //遍历到最后,如果curA!=curB，说明两个链表不相交
            return null;
        }
        //这里需要初始化
        curA = headA;
        curB = headB;
        int res = len1 - len2;
        if (res > 0)    //链表1比较长，链表1就先走len1-len2步
            for (int i = 0; i < res; i++) {
                curA = curA.next;
            }
        if (res < 0)    //如果链表2比较长，链表2就先走len2-len1步
            for (int i = 0; i < Math.abs(res); i++) {
                curB = curB.next;
            }
        while (curA != curB) {  //开始齐头并进，直到找到第一个公共结点
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
