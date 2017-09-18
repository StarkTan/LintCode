package com.stark._1_100._61_70;

import com.stark.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Stark on 2017/9/18.
 * 给出一棵二叉树，返回其节点值的后序遍历。
 */
public class LintCode_68 {

    public List<Integer> postorderTraversal_V1(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        result.addAll(postorderTraversal_V1(root.left));
        result.addAll(postorderTraversal_V1(root.right));
        result.add(root.val);
        return result;
    }


    public List<Integer> postorderTraversal_V2(TreeNode root) {
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
                stack.push(node);
                if(node.right!=null){
                    stack.push(node.right);
                    node.right=null;
                }
                if(node.left!=null){
                    stack.push(node.left);
                    node.left=null;
                }
            }
        }
        return result;
    }

}
