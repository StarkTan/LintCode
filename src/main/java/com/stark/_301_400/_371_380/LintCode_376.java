package com.stark._301_400._371_380;

import com.stark.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/9/17.
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
 * 一个有效的路径，指的是从根节点到叶节点的路径。
 */
public class LintCode_376 {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root==null) {
            return list;
        }
        int num = root.val;

        int nextTarget = target - num;

        if (root.left == null && root.right == null) {
            if (nextTarget == 0) {
                List<Integer> list1 = new ArrayList<Integer>(10);
                list1.add(num);
                list.add(list1);
            }
        }
        if (root.left != null) {
            List<List<Integer>> list2 = binaryTreePathSum(root.left, nextTarget);
            if (!list2.isEmpty()) {
                for (List<Integer> l : list2) {
                    l.add(0, num);
                }
                list.addAll(list2);
            }
        }
        if (root.right != null) {
            List<List<Integer>> list2 = binaryTreePathSum(root.right, nextTarget);
            if (!list2.isEmpty()) {
                for (List<Integer> l : list2) {
                    l.add(0, num);
                }
                list.addAll(list2);
            }
        }
        return list;
    }
}
