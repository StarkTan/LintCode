package com.stark._601_700._691_700;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/11/27.
 * 在一棵二叉搜索树中, 只有两个节点是被交换的. 找到这些节点并交换, 如果没有节点被交换就返回原来的树的根节点.
 */
public class LintCode_691 {

    TreeNode pre = null;
    TreeNode p = null;
    TreeNode q = null;

    public TreeNode bstSwappedNode(TreeNode root) {
        solve(root);
        if (p != null && q != null) {
            int temp = p.val;
            p.val = q.val;
            q.val = temp;
        }
        return root;
    }

    private void solve(TreeNode root) {
        if (root == null) return;
        solve(root.left);
        if (pre == null) {
            pre = root;
        } else {
            if (root.val < pre.val && p == null) {
                p = pre;
            }
            if (root.val < pre.val && p != null) {
                q = root;
            }
            pre = root;
        }
        solve(root.right);
    }
}
