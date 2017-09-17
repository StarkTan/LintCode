package com.stark._601_700._631_640;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/9/17.
 * 在二叉树中寻找值最大的节点并返回。
 */
public class LintCode_632 {
    public TreeNode maxNode(TreeNode root) {
        if(root==null) return null;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode res = root;
        if(root.left!=null) {
            left = maxNode(root.left);
            if(left.val>res.val) res = left;
        }
        if(root.right!=null) {
            right = maxNode(root.right);
            if(right.val>res.val) res = right;
        }
        return res;
    }
}
