package com.stark._1_100._91_100;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/17.
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的距离。
 */
public class LintCode_97 {
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null){
            return 0;
        }else {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
}
