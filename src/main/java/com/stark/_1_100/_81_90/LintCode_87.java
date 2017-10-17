package com.stark._1_100._81_90;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/11.
 * 给定一棵具有不同节点值的二叉查找树，删除树中与给定值相同的节点。
 * 如果树中没有相同值的节点，就不做任何处理。你应该保证处理之后的树仍是二叉查找树。
 */
public class LintCode_87 {
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode res = null;
        TreeNode parent = null;
        TreeNode search = root;
        while (search != null) {
            int val = search.val;
            if (val == value) {
                res = search;
                break;
            } else if (val < value) {
                parent = search;
                search = search.right;
            } else {
                parent = search;
                search = search.left;
            }
        }
        if (res == null) {
            return root;
        }
        //为叶子节点
        if (res.left == null && res.right == null) {
            if (parent == null) {
                return null;
            } else {
                if (parent.val > value) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            return root;
        }
        //单边
        if (res.left == null) {
            if (parent == null) {
                return res.right;
            } else {
                if (parent.val > value) {
                    parent.left = res.right;
                } else {
                    parent.right = res.right;
                }
            }
            return root;
        }
        if (res.right == null) {
            if (parent == null) {
                return res.left;
            } else {
                if (parent.val > value) {
                    parent.left = res.left;
                } else {
                    parent.right = res.left;
                }
            }
            return root;
        }
        //两边都有 选择找左边最右节点
        TreeNode change = res.left;
        while (change.right != null) {
            change = change.right;
        }
        if (change == res.left) {
            change.right = res.right;
            if (parent == null) {
                return change;
            } else {
                if (parent.val > value) {
                    parent.left = change;
                } else {
                    parent.right = change;
                }
            }
            return root;
        } else {
            change.right = res.right;
            change.left = res.left;
            if (parent == null) {
                return change;
            } else {
                if (parent.val > value) {
                    parent.left = change;
                } else {
                    parent.right = change;
                }
            }
            return root;
        }
    }
}
