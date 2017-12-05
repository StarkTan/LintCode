package com.stark._1_100._71_80;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/12/1.
 */
public class LintCode_73 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        int pre_begin = 0;
        int in_begin = 0;
        int pre_end = preorder.length - 1;
        int in_end = inorder.length - 1;
        return solve(preorder, pre_begin, pre_end, inorder, in_begin, in_end);
    }

    private TreeNode solve(int[] preorder, int pre_begin, int pre_end,
                           int[] inorder, int in_begin, int in_end) {
        if (pre_begin > pre_end) return null;
        int val = preorder[pre_begin];
        TreeNode node = new TreeNode(val);
        if (pre_begin == pre_end) return node;
        int pos = in_begin;
        for (; pos <= in_end; pos++)
            if (inorder[pos] == val) break;
        int preLen = pos - in_begin;
        node.left = solve(preorder, pre_begin + 1, pre_begin + preLen,
                inorder, in_begin, pos - 1);
        node.right = solve(preorder, pre_begin + preLen + 1, pre_end,
                inorder, pos + 1, in_end);
        return node;
    }
}
