package com.stark._301_400._371_380;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_375 {
    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.left = cloneTree(root.left);
        node.right = cloneTree(root.right);
        return node;
    }
}
