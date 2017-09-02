package com.stark._1_100._11_20;

import com.stark.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/9/2.
 * 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。找到树中所有值在 k1 到 k2 范围内的节点。
 * 即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值。
 */
public class LintCode_11 {
    //递归处理最为方便
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            search(list, root, k1, k2);
        }
        return list;
    }

    private void search(List<Integer> list, TreeNode node, int k1, int k2) {
        if (node.left != null) search(list, node.left, k1, k2);
        if (node.val >= k1 && node.val <= k2) {
            list.add(node.val);
        }
        if (node.right != null) search(list, node.right, k1, k2);
    }
}
