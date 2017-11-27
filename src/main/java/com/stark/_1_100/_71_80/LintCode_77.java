package com.stark._1_100._71_80;

/**
 * Created by Stark on 2017/11/27.
 * 给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。
 */
public class LintCode_77 {
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int lenA = A.length();
        int lenB = B.length();
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[lenA][lenB];
    }
}
