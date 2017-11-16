package com.stark._101_200._101_110;

import com.stark.entity.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stark on 2017/11/2.
 * 给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点。
 * 返回一个深拷贝的链表。
 */
public class LintCode_105 {
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        RandomListNode pre = new RandomListNode(0);
        Map<Integer, RandomListNode> map = new HashMap<>();
        solve(pre, map, head, true);
        return pre.next;
    }

    private void solve(RandomListNode pre, Map<Integer, RandomListNode> map, RandomListNode node, boolean next) {
        if (node == null) return;
        int label = node.label;
        RandomListNode newNode = null;
        if (map.containsKey(label)) {
            newNode = map.get(label);
        } else {
            newNode = new RandomListNode(label);
            map.put(label, newNode);
        }
        if (next) {
            pre.next = newNode;
            solve(newNode, map, node.next, true);
            solve(newNode, map, node.random, false);
        } else {
            pre.random = newNode;
        }

    }
}
