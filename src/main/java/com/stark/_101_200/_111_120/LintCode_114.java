package com.stark._101_200._111_120;

/**
 * Created by Stark on 2017/11/28.
 * 有一个机器人的位于一个 m × n 个网格左上角。
 * <p>
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * <p>
 * 问有多少条不同的路径？
 */
public class LintCode_114 {

    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
