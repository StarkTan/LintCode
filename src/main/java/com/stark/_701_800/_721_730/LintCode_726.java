package com.stark._701_800._721_730;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/12/4.
 * 如果一棵二叉树所有节点都有零个或两个子节点, 那么这棵树为满二叉树.
 * 反过来说, 满二叉树中不存在只有一个子节点的节点. 更多关于满二叉树的信息可以在这里找到
 */
public class LintCode_726 {
    public boolean isFullTree(TreeNode root) {
        // write your code here
        if (root == null) return true; //针对根节点为空
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        return isFullTree(root.left) && isFullTree(root.right);
    }
}
