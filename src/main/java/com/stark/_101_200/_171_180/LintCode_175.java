package com.stark._101_200._171_180;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/18.
 * 翻转一棵二叉树
 */
public class LintCode_175 {
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        invertBinaryTree(left);
        invertBinaryTree(right);
        root.left = right;
        root.right = left;
    }
}
