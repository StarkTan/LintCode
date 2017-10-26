package com.stark._1_100._91_100;

import com.stark.entity.ListNode;

/**
 * 在 O(n log n) 时间复杂度和常数级的空间复杂度下给链表排序。
 */
public class LintCode_98 {
    //新建链表 超时
    public ListNode sortList_V1(ListNode head) {
        // write your code here
        ListNode res = new ListNode(0);
        ListNode newPre = res;
        ListNode pre = new ListNode(0);
        pre.next = head;
        while (pre.next != null) {
            ListNode before = pre;
            ListNode targetBefore = pre;
            int min = Integer.MAX_VALUE;
            while (before.next != null) {
                if (before.next.val < min) {
                    targetBefore = before;
                    min = before.next.val;
                }
                before = before.next;
            }
            ListNode target = targetBefore.next;
            targetBefore.next = target.next;
            target.next = null;
            newPre.next = target;
            newPre = target;
        }
        return res.next;
    }

    //使用快排,标记相同元素
    public ListNode sortList_V2(ListNode head) {
        //
        if (head == null) return null;
        ListNode begin = new ListNode(0);
        begin.next = head;
        solve(begin, null);
        return begin.next;
    }

    private void solve(ListNode begin, ListNode end) {
        if (begin.next == end || begin.next.next == end) {
            return;
        }
        ListNode nextEnd = begin.next; //基准
        ListNode nextBegin = begin.next; //基准
        ListNode before = begin.next;
        while (before.next != end) {
            ListNode cur = before.next;
            if (cur.val > nextEnd.val) {
                before = before.next;
            } else if (cur.val < nextEnd.val) {
                before.next = cur.next;
                cur.next = begin.next;
                begin.next = cur;
            } else {
                if (nextBegin.next == cur) {
                    before = before.next;
                    nextBegin = cur;
                } else {
                    before.next = cur.next;
                    cur.next = nextBegin.next;
                    nextBegin.next = cur;
                    nextBegin = cur;
                }

            }
        }
        solve(begin, nextEnd);
        solve(nextBegin, end);
    }


    public static void main(String[] args) {
        LintCode_98 test = new LintCode_98();
        ListNode l = new ListNode(21);
        ListNode ll = new ListNode(26);
        ListNode lll = new ListNode(25);
        ListNode llll = new ListNode(31);
        ListNode lllll = new ListNode(4);
        l.next = ll;
        ll.next = lll;
        lll.next = llll;
        llll.next = lllll;
        ListNode listNode = test.sortList_V2(l);
        System.out.println(listNode);
    }
}
