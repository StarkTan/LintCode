package com.stark._101_200._161_170;

import com.stark.entity.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Stark on 2017/12/5.
 */
public class LintCode_167 {
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                queue1.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                queue2.add(l2.val);
                l2 = l2.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode pre = res;
        int sum = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty() || sum == 1) {
            if (!queue1.isEmpty()) sum += queue1.poll();
            if (!queue2.isEmpty()) sum += queue2.poll();
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            sum = sum / 10;
        }
        return res.next;
    }
}
