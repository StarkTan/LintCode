package com.stark._101_200._101_110;

import com.stark.entity.ListNode;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Stark on 2017/10/27.
 * 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
 */
public class ListCode_104 {
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        Map<Integer, ListNode> map = new TreeMap<>();
        for (ListNode node : lists) {
            while (node != null) {
                int var = node.val;
                ListNode next = node.next;
                if (map.containsKey(var)) {
                    node.next = map.get(var);
                } else {
                    node.next = null;
                }
                map.put(var, node);
                node = next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode pre = res;
        Set<Map.Entry<Integer, ListNode>> entries = map.entrySet();
        for (Map.Entry<Integer, ListNode> entry : entries) {
            while (pre.next != null) {
                pre = pre.next;
            }
            pre.next = entry.getValue();
        }
        return res.next;
    }
}
