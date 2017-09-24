package com.stark._401_500._451_460;

import com.stark.entity.TreeNode;

import java.util.Stack;

/**
 * Created by Stark on 2017/9/21.
 * 将一棵二叉树按照前序遍历拆解成为一个假链表。
 * 所谓的假链表是说，用二叉树的 right 指针，来表示链表中的 next 指针。
 */
public class LintCode_453 {
    public void flatten(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        if (node.right != null) {
            stack.push(node.right);
            node.right = null;
        }
        if (node.left != null) {
            stack.push(node.left);
            node.left = null;
        }
        TreeNode next = node;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
                cur.right = null;
            }
            if (cur.left != null) {
                stack.push(cur.left);
                cur.left = null;
            }
            next.right = cur;
            next = cur;
        }
    }
}
