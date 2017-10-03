package com.stark._101_200._101_110;

import com.stark.entity.ListNode;
import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/3.
 * 给出一个所有元素以升序排序的单链表，将它转换成一棵高度平衡的二分查找树
 */
public class LintCode_106 {
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) return null;
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        if (len == 1) {
            return new TreeNode(head.val);

        }
        if (len == 2) {
            TreeNode treeNode = new TreeNode(head.val);
            treeNode.right = new TreeNode(head.next.val);
            return treeNode;
        }

        int mid = (len + 1) / 2;
        ListNode midNode = head;
        //找到前面一节点
        int pos = 2;
        while (pos != mid) {
            midNode = midNode.next;
            pos++;
        }
        TreeNode treeNode = new TreeNode(midNode.next.val);
        ListNode right = midNode.next.next;
        midNode.next.next =null;
        midNode.next=null;
        ListNode left = head;
        treeNode.left = sortedListToBST(left);
        treeNode.right = sortedListToBST(right);
        return treeNode;
    }
}
