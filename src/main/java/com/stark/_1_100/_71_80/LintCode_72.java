package com.stark._1_100._71_80;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/11/24.
 * 根据中序遍历和后序遍历树构造二叉树
 */
public class LintCode_72 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        int in_begin = 0;
        int post_begin = 0;
        int in_end = inorder.length - 1;
        int post_end = postorder.length - 1;
        return solve(inorder, in_begin, in_end, postorder, post_begin, post_end);
    }

    private TreeNode solve(int[] inorder, int in_begin, int in_end,
                           int[] postorder, int post_begin, int post_end) {
        if (in_begin == in_end) {
            return new TreeNode(inorder[in_begin]);
        }
        if (in_begin > in_end) {
            return null;
        }
        int mid = postorder[post_end];
        TreeNode res = new TreeNode(mid);
        int pos = in_begin;
        for (; pos <= in_end; pos++) {
            if (mid == inorder[pos]) break;
        }
        int bet_begin = pos - in_begin - 1;
        int bet_end = in_end - pos - 1;
        res.left = solve(inorder, in_begin, pos - 1,
                postorder, post_begin, post_begin + bet_begin);
        res.right = solve(inorder, pos + 1, in_end,
                postorder, post_end - bet_end - 1, post_end - 1);
        return res;
    }

    public static void main(String[] args) {
        LintCode_72 lintCode_72 = new LintCode_72();
        TreeNode treeNode = lintCode_72.buildTree(new int[]{}, new int[]{});
        System.out.println(treeNode);
    }
}
