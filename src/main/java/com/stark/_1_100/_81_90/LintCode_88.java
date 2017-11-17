package com.stark._1_100._81_90;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/11/17.
 * 给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。
 * 最近公共祖先是两个节点的公共的祖先节点且具有最大深度。
 */
public class LintCode_88 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
