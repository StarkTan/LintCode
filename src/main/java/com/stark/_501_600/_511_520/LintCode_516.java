package com.stark._501_600._511_520;

/**
 * Created by Stark on 2017/10/27.
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，共有k种颜色。
 * 每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。
 * <p>
 * 费用通过一个nxk 的矩阵给出，比如cost[0][0]表示房屋0染颜色0的费用，
 * cost[1][2]表示房屋1染颜色2的费用。
 */
public class LintCode_516 {
    public int minCostII(int[][] costs) {
        // write your code here
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        //第i个屋子选用每一个颜料的最低价钱
        int[][] dp = new int[n][k];
        //用来记录下一次去获取的最小值
        int min = 0;
        int secMin = 0;
        int minPos = -1;
        //初始化
        for (int i = 0; i < n; i++) {
            int next_min = Integer.MAX_VALUE;
            int next_secMin = Integer.MAX_VALUE;
            int next_minPos = -1;
            for (int j = 0; j < k; j++) {
                if (j == minPos) {
                    dp[i][j] = secMin + costs[i][j];
                } else {
                    dp[i][j] = min + costs[i][j];
                }
                if (dp[i][j] < next_min) {
                    next_minPos = j;
                    next_secMin = next_min;
                    next_min = dp[i][j];
                } else if (dp[i][j] < next_secMin) {
                    next_secMin = dp[i][j];
                }
            }
            min = next_min;
            minPos = next_minPos;
            secMin = next_secMin;
        }
        return min;
    }

    public static void main(String[] args) {
        LintCode_516 lintCode_516 = new LintCode_516();
        int i = lintCode_516.minCostII(new int[][]{new int[]{1, 2, 3}, new int[]{1, 4, 6}});
        System.out.println(i);
    }
}
