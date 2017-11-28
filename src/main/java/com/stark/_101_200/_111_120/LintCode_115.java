package com.stark._101_200._111_120;

/**
 * Created by Stark on 2017/11/28.
 * "不同的路径" 的跟进问题：
 * <p>
 * 现在考虑网格中有障碍物，那样将会有多少条不同的路径？
 * <p>
 * 网格中的障碍和空位置分别用 1 和 0 来表示。
 */
public class LintCode_115 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i == 1 && j == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
