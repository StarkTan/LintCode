package com.stark.entity;

/**
 * Created by Stark on 2017/9/2.
 * 树节点
 */
public class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

