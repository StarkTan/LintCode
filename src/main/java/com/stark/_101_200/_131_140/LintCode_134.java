package com.stark._101_200._131_140;

/**
 * Created by Stark on 2017/10/13.
 * 为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据（get）和写入数据（set）。
 * 获取数据get(key)：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
 * 写入数据set(key, value)：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。
 */
public class LintCode_134 {
    int size = 0;
    int cap = 0;
    ListNode head = null;

    public LintCode_134(int capacity) {
        // do intialization if necessary
        this.cap = capacity;
        this.head = new ListNode();
        head.next = null;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.key == key) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return -1;
        }
        pre.next = cur.next;
        cur.next = head.next;
        head.next = cur;
        return cur.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        //查看是否存在相同key
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.key == key) {
                break;
            }
            if (cur.next == null) {
                cur = null;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            if (size == cap) {
                pre.next = null;
            } else {
                size++;
            }
        } else {
            pre.next = cur.next;
            cur.next = null;
        }
        ListNode newNode = new ListNode();
        newNode.key = key;
        newNode.value = value;
        newNode.next = head.next;
        head.next = newNode;
    }

    class ListNode {
        int key;
        int value;
        public ListNode next;
    }

    public static void main(String[] args) {
        LintCode_134 test = new LintCode_134(2);
        test.set(2, 1);
        test.set(1, 2);
        System.out.println(test.get(2));
        test.set(4, 1);
        System.out.println(test.get(1));
    }
}
