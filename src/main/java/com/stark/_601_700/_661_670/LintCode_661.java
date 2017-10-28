package com.stark._601_700._661_670;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/27.
 * Given a Binary Search Tree (BST),
 * convert it to a Greater Tree such that every key of the original
 * BST is changed to the original key plus sum of all keys
 * greater than the original key in BST.
 */
public class LintCode_661 {
    public TreeNode convertBST(TreeNode root) {
        // Write your code here
        if(root == null){
            return root;
        }
        int temp = search(root , 0);
        return root;
    }

    public int search(TreeNode root , int count){
        if(root == null){
            return 0;
        }
        int right = search(root.right , count);
        int left = search(root.left , count + root.val + right);
        int result = right + left + root.val;
        root.val += right + count;
        return result;
    }
}
