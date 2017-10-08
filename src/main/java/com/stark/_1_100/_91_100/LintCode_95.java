package com.stark._1_100._91_100;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/8.
 * 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
 * 一棵BST定义为：
 * 节点的左子树中的值要严格小于该节点的值。
 * 节点的右子树中的值要严格大于该节点的值。
 * 左右子树也必须是二叉查找树。
 * 一个节点的树也是二叉查找树。
 */
public class LintCode_95 {
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        int var = root.val;
        if (root.left != null) {
            int left = root.left.val;
            if (left >= var) return false;
            int[] solve = solve(root.left);
            if (solve[0] == 1) return false;
            else if (solve[2] >= var) return false;
        }
        if (root.right != null) {
            int right = root.right.val;
            if (right <= var) return false;
            int[] solve = solve(root.right);
            if (solve[0] == 1) return false;
            else if (solve[1] <= var) return false;
        }
        return true;
    }

    private int[] solve(TreeNode node) {
        int[] res = new int[3];
        int var = node.val;
        res[1] = var;
        res[2] = var;

        if (node.left != null) {
            int left = node.left.val;
            if (left >= var) {
                res[0] = 1;
                return res;
            }
            int[] solve = solve(node.left);
            if (solve[0] == 1) {
                res[0] = 1;
                return res;
            } else if (solve[2] >= var) {
                res[0] = 1;
                return res;
            }
            res[1] = solve[1];
        }
        if (res[0] == 1) return res;
        if (node.right != null) {
            int right = node.right.val;
            if (right <= var) {
                res[0] = 1;
                return res;
            }
            int[] solve = solve(node.right);
            if (solve[0] == 1) {
                res[0] = 1;
                return res;
            } else if (solve[1]<=var) {
                res[0] = 1;
                return res;
            }
            res[2] = solve[2];
        }
        return res;
    }
}
