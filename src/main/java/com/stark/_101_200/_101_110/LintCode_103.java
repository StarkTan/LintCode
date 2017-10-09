package com.stark._101_200._101_110;

import com.stark.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/9.
 * 给定一个链表，判断它是否有环。
 */
public class LintCode_103 {
    public ListNode detectCycle(ListNode head) {
        // write your code here
        //不用额外空间，则架设循环的长度不超过100,容易超时
        /*ListNode pos = head;
        ListNode run = pos;
        while (true) {
            for (int i = 0; i < 100; i++) {
                if (run == null) return null;
                run = run.next;
                if (run == null) {
                    return null;
                }
                if (run.equals(pos)) {
                    return pos;
                }
            }
            pos = pos.next;
            run = pos;
        }*/
        List<ListNode> nodes = new ArrayList<>();
        while (head!=null){
            if(nodes.contains(head)){
                return head;
            }else {
                nodes.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
