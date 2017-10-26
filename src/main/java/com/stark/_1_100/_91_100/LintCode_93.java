package com.stark._1_100._91_100;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/23.
 * 给定一个二叉树,确定它是高度平衡的。
 * 对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。
 */
public class LintCode_93 {
    public boolean isBalanced(TreeNode node) {
        return dep(node) != -1;
    }

    private int dep(TreeNode node) {
        if (node == null) return 0;
        int dep_left = dep(node.left);
        int dep_right = dep(node.right);
        if (dep_left == -1 || dep_right == -1
                || dep_left - dep_right > 1 || dep_left - dep_right < -1) {
            return -1;
        }
        return Math.max(dep_left, dep_right) + 1;
    }
}
