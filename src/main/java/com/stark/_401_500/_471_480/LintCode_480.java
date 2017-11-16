package com.stark._401_500._471_480;

import com.stark.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/30.
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。
 */
public class LintCode_480 {
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        if (root.right == null && root.left == null) {
            res.add(root.val + "");
        } else {
            List<String> left = binaryTreePaths(root.left);
            List<String> right = binaryTreePaths(root.right);
            for (String s : left) {
                res.add(root.val + "->" + s);
            }
            for (String s : right) {
                res.add(root.val + "->" + s);
            }
        }
        return res;
    }
}
