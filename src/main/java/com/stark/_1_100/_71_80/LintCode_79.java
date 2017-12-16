package com.stark._1_100._71_80;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_79 {
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char a = A.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char b = B.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) max = dp[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
    }
}
