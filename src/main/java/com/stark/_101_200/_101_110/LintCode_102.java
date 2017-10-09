package com.stark._101_200._101_110;

import com.stark.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/9.
 * 给定一个链表，判断它是否有环。
 */
public class LintCode_102 {
    public boolean hasCycle(ListNode head) {
        // write your code here
        List<ListNode> nodes = new ArrayList<>();
        while (head!=null){
            if(nodes.contains(head)){
                return true;
            }else {
                nodes.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
