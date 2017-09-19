package com.stark._101_200._101_110;

/**
 * Created by Stark on 2017/9/19.
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 */
public class LintCode_109 {
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int n = triangle.length;
        for(int i =0;i<n-1;i++){
            int[] before = triangle[i];
            int[] next = triangle[i+1];
            next[0] = next[0]+before[0];
            next[i+1] = next[i+1]+before[i];
            for(int j=1;j<=i;j++){
                next[j] =Math.min(before[j-1],before[j])+next[j];
            }
        }
        int[] last = triangle[n-1];
        int res = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            res =Math.min(res,last[i]);
        }
        return res;



    }
}
