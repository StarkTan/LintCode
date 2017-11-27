package com.stark._601_700._681_690;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/11/24.
 * 给一棵二叉搜索树以及一个整数 n, 在树中找到和为 n 的两个数字
 */
public class LintCode_689 {
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if (root == null) {
            return null;
        }
        int num = root.val;
        int rest = n - num;
        TreeNode res = null;
        if (rest > num) res = solve(root.right, rest);
        else if (rest < num) res = solve(root.left, rest);
        if (res == null) {
            int[] left = twoSum(root.left, n);
            if (left != null) return left;
            int[] right = twoSum(root.right, n);
            if (right != null) return right;
        } else {
            return new int[]{root.val, res.val};
        }
        return null;
    }

    private TreeNode solve(TreeNode left, int rest) {
        if (left == null) return null;
        if (left.val == rest) {
            return left;
        } else if (left.val > rest) {
            return solve(left.left, rest);
        } else {
            return solve(left.right, rest);
        }
    }
}
