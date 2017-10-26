package com.stark._101_200._161_170;

import com.stark.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/23.
 * 给出n，生成所有由1...n为节点组成的不同的二叉查找树
 *
 */
public class LintCode_164 {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            List<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        }
        return solve(1, n);
    }

    private List<TreeNode> solve(int begin, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (begin == end) {
            res.add(new TreeNode(begin));
            return res;
        }
        for (int i = begin; i <= end; i++) {

            if (i == begin) {
                List<TreeNode> solve = solve(begin + 1, end);
                for (TreeNode right : solve) {
                    TreeNode treeNode = new TreeNode(begin);
                    treeNode.right = right;
                    res.add(treeNode);
                }
                continue;
            }
            if (i == end) {
                List<TreeNode> solve = solve(begin, end - 1);
                for (TreeNode left : solve) {
                    TreeNode treeNode = new TreeNode(end);
                    treeNode.left = left;
                    res.add(treeNode);
                }
                continue;
            }
            List<TreeNode> lefts = solve(begin, i - 1);
            List<TreeNode> rights = solve(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_164 tets = new LintCode_164();
        int size = tets.generateTrees(9).size();
        System.out.println(size);
    }
}
