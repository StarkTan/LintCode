package com.stark._1_100._81_90;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/30.
 * 给定一棵二叉查找树和一个新的树节点，将节点插入到树中。
 */
public class LintCode_85 {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) return node;
        TreeNode res = root;
        while (true) {
            if (root.val > node.val) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = node;
                    break;
                }
            } else if (root.val < node.val) {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = node;
                    break;
                }
            } else {
                break;
            }
        }
        return res;
    }
}
