package com.stark._1_100._71_80;

import com.stark.entity.TreeNode;

import java.util.*;

/**
 * Created by Stark on 2017/10/3.
 * 给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行）
 */
public class LintCode_71 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack_right = new Stack<>();
        Stack<TreeNode> stack_left = new Stack<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        stack_right.add(root);
        while (!stack_left.isEmpty() || !stack_right.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!stack_left.isEmpty()) {
                while (!stack_left.isEmpty()) {
                    TreeNode pop = stack_left.pop();
                    list.add(pop.val);
                    if (pop.right != null) stack_right.add(pop.right);
                    if (pop.left != null) stack_right.add(pop.left);
                }
            } else if (!stack_right.isEmpty()) {
                while (!stack_right.isEmpty()) {
                    TreeNode pop = stack_right.pop();
                    list.add(pop.val);
                    if (pop.left != null) stack_left.add(pop.left);
                    if (pop.right != null) stack_left.add(pop.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
