package com.stark._1_100._61_70;

import com.stark.entity.TreeNode;

import java.util.*;

/**
 * Created by Stark on 2017/9/18.
 * 给出一棵二叉树，返回其节点值的前序遍历。
 */
public class LintCode_66 {
    //递归
    public List<Integer> preorderTraversal_V1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal_V1(root.left));
        res.addAll(preorderTraversal_V1(root.right));
        return res;
    }
    //非递归
    public List<Integer> preorderTraversal_V2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return res;
    }
}
