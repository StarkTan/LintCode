package com.stark._301_400._371_380;

import com.stark.entity.DoublyListNode;
import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/19.
 * 将一个二叉查找树按照中序遍历转换成双向链表。
 */
public class LintCode_378 {
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        DoublyListNode pre = new DoublyListNode(0);
        solve(pre, root);
        DoublyListNode res = pre.next;
        res.prev = null;
        return res;
    }

    private DoublyListNode solve(DoublyListNode pre, TreeNode root) {
        if (root.left != null) {
            pre = solve(pre, root.left);
        }
        DoublyListNode newNode = new DoublyListNode(root.val);
        newNode.prev = pre;
        pre.next = newNode;
        pre = newNode;
        if (root.right != null) {
            pre = solve(pre, root.right);
        }
        return pre;
    }
}
