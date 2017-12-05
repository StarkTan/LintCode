package com.stark._1_100._61_70;

import com.stark.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Stark on 2017/12/4.
 * 给出一棵二叉树，返回其节点值从底向上的层次序遍历（按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）
 */
public class LintCode_70 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        solve(queue, res);
        return res;
    }
    private void solve(Queue<TreeNode> queue, List<List<Integer>> res) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> newQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) continue;
            list.add(poll.val);
            newQueue.add(poll.left);
            newQueue.add(poll.right);
        }
        if(!list.isEmpty())res.add(0, list);
        if (!newQueue.isEmpty()) solve(newQueue, res);
    }
}
