package com.stark._401_500._441_450;

import com.stark.entity.ListNode;

import java.util.*;

/**
 * Created by Stark on 2017/12/5.
 * 给你一个链表以及一个k,将这个链表从头指针开始每k个翻转一下。
 * 链表元素个数不是k的倍数，最后剩余的不用翻转。
 */
public class LintCode_450 {

    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        int total = 0;
        ListNode cur = head;
        while (cur != null) {
            total++;
            cur = cur.next;
        }
        Map<Integer, Stack<ListNode>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(i, new Stack<>());
        }
        int end = total % k;
        int left = total;
        while (left > end) {
            for (int i = 0; i < k; i++) {
                cur = head;
                head = head.next;
                cur.next = null;
                map.get(i).push(cur);
                left--;
            }
        }
        while (left < total) {
            for (int i = k - 1; i >= 0; i--) {
                ListNode pop = map.get(i).pop();
                pop.next = head;
                head = pop;
                left++;
            }
        }
        return head;
    }
}
