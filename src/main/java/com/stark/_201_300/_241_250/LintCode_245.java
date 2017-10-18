package com.stark._201_300._241_250;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/18.
 * 有两个不同大小的二叉树： T1 有上百万的节点； T2 有好几百的节点。请设计一种算法，判定 T2 是否为 T1的子树。
 */
public class LintCode_245 {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T2 == null) {
            return true;
        }
        if (T1 == null) {
            return false;
        }
        if (solve(T1, T2)) {
            return true;
        } else {
            return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
        }
    }

    private boolean solve(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return solve(t1.left, t2.left) && solve(t1.right, t2.right);
    }
}
