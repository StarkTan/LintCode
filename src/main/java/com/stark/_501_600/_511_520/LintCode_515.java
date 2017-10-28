package com.stark._501_600._511_520;

/**
 * Created by Stark on 2017/10/27.
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。每个房屋染不同的颜色费用也不同，
 * 你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。
 * <p>
 * 费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用。
 */
public class LintCode_515 {
    public int minCost(int[][] costs) {
        // write your code here
        int len = costs.length;
        if (len == 0) return 0;
        //第i个屋子选用每一个颜料的最低价钱
        int[][] dp = new int[len][3];
        //初始化
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i][2];
        }
        return Math.min(dp[len-1][0],Math.min(dp[len-1][1],dp[len-1][2]));
    }
}
