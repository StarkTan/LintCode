package com.stark._201_300._221_230;

import com.stark.entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Stark on 2017/12/4.
 */
public class LintCode_223 {
    public boolean isPalindrome(ListNode head) {
        // write your code here
        int len = 0;
        ListNode nodeLen = head;
        while (nodeLen != null) {
            len++;
            nodeLen = nodeLen.next;
        }
        if (len <= 1) return true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len / 2; i++) {
            stack.push(head.val);
            head = head.next;
        }
        if (len % 2 == 1) head = head.next;
        while (!stack.isEmpty() && head != null) {
            if (stack.pop() != head.val) return false;
            head = head.next;
        }
        if (!stack.isEmpty() || head != null) return false;
        return true;
    }
}
