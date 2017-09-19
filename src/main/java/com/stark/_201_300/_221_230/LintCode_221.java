package com.stark._201_300._221_230;

import com.stark.entity.ListNode;

import java.util.Stack;

/**
 * Created by Stark on 2017/9/19.
 * 假定用一个链表表示两个数，其中每个节点仅包含一个数字。
 * 假设这两个数的数字顺序排列，请设计一种方法将两个数相加，并将其结果表现为链表的形式。
 */
public class LintCode_221 {
    public ListNode addList(ListNode l1, ListNode l2) {
        ListNode res = null;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int newNum = stack1.pop() + stack2.pop() + carry;
            if (newNum >= 10) {
                carry = 1;
                newNum = newNum % 10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(newNum);
            newNode.next = res;
            res = newNode;
        }
        Stack<Integer> longer = !stack1.isEmpty() ? stack1 : stack2;
        while (!longer.isEmpty()) {
            int newNum = longer.pop() + carry;
            if (newNum >= 10) {
                carry = 1;
                newNum = newNum % 10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(newNum);
            newNode.next = res;
            res = newNode;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = res;
            res = newNode;
        }
        return res;
    }
}
