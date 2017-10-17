package com.stark._101_200._151_160;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/17.
 * 给定一个二叉树，找出其最小深度。
 * 二叉树的最小深度为根节点到最近叶子节点的距离。
 */
public class LintCode_155 {
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return 1;
        } else if (left == null || right == null) {
            return Math.max(minDepth(left), minDepth(right)) + 1;
        }else {
            return Math.min(minDepth(left), minDepth(right)) + 1;
        }
    }
}
