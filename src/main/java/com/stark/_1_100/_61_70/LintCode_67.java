package com.stark._1_100._61_70;

import com.stark.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Stark on 2017/9/18.
 * 给出一棵二叉树，返回其节点值的中序序遍历。
 */
public class LintCode_67 {

    //递归
    public List<Integer> inorderTraversal_V1(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        result.addAll(inorderTraversal_V1(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal_V1(root.right));
        return result;
    }

    //非递归
    public List<Integer> inorderTraversal_V2(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left==null&&node.right==null){
                result.add(node.val);
            }else {
                if(node.right!=null){
                    stack.push(node.right);
                    node.right=null;
                }
                stack.push(node);
                if(node.left!=null){
                    stack.push(node.left);
                    node.left=null;
                }
            }
        }
        return result;
    }
}
