package com.stark._1_100._61_70;

import com.stark.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Stark on 2017/9/18.
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 */
public class LintCode_69 {

    //只使用一个队列
    public List<List<Integer>> levelOrder_V1(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        res.add(list);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll==null){
                if(!queue.isEmpty()){
                    queue.add(null);
                    res.add(new ArrayList<>());
                }
            }else {
                res.get(res.size()-1).add(poll.val);
                if(poll.left!=null)queue.add(poll.left);
                if(poll.right!=null)queue.add(poll.right);
            }
        }
        return res;
    }

}
