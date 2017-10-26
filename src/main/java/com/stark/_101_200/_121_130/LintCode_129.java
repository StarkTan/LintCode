package com.stark._101_200._121_130;

import com.stark.entity.ListNode;

/**
 * Created by Stark on 2017/10/21.
 * 哈希表容量的大小在一开始是不确定的。
 * 如果哈希表存储的元素太多（如超过容量的十分之一），我们应该将哈希表容量扩大一倍，
 * 内存不足 无法优化了
 */
public class LintCode_129 {
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int cap = hashTable.length;
        int newCap = 2 * cap;
        ListNode[] res = new ListNode[newCap];
        for (ListNode node : hashTable) {
            while (node != null) {
                int var = node.val;
                ListNode cur = node;
                node = node.next;
                cur.next = null;
                int hash = var % newCap;
                if (var < 0) {
                    hash = (hash + newCap) % newCap;
                }

                if (res[hash] == null) {
                    res[hash] = cur;
                } else {
                    ListNode pre = res[hash];
                    while (pre.next != null) {
                        pre = pre.next;
                    }
                    pre.next = cur;
                }
            }
        }
        return res;
    }
}
