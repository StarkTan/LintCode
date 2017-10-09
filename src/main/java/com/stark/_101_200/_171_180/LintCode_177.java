package com.stark._101_200._171_180;

import com.stark.entity.TreeNode;

/**
 * Created by Stark on 2017/10/9.
 * 给一个排序数组（从小到大），将其转换为一棵高度最小的排序二叉树。
 */
public class LintCode_177 {
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        int begin = 0;
        int end = A.length-1;

        return solve(A,begin,end);
    }

    private TreeNode solve(int[] a, int begin, int end) {
        if(begin>end) return null;
        int mid = (begin+end)/2;
        TreeNode res = new TreeNode(a[mid]);
        res.left = solve(a,begin,mid-1);
        res.right = solve(a,mid+1,end);
        return res;
    }

}
