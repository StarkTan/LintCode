package com.stark._101_200._121_130;

import java.util.Arrays;

/**
 * Created by Stark on 2017/10/16.
 * 背包问题
 */
public class LintCode_125 {
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[][] dp = new int[A.length][m + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = A[0] <= i ? V[0] : 0;
        }
        for (int i = 1; i< A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if(j<A[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-A[i]]+V[i]);
                }
            }
        }
        return dp[A.length-1][m];
    }

    public static void main(String[] args) {
        LintCode_125 lintCode_125 = new LintCode_125();
        int i = lintCode_125.backPackII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4});
        System.out.println(i);
    }

}
