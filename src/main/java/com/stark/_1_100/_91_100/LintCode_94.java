package com.stark._1_100._91_100;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_94 {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // write your code here
        solve(root);
        return res;
    }

    //返回被上级节点调用时的最大值
    //比较自身闭环的最大值
    private int solve(TreeNode node) {
        if (node == null) return 0;
        int left = solve(node.left);
        if (left < 0) left = 0;
        int right = solve(node.right);
        if (right < 0) right = 0;
        int self = node.val + left + right;
        res = Math.max(res, self);
        return Math.max(left, right) + node.val;
    }
}
