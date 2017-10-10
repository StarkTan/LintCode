package com.stark._501_600._511_520;

/**
 * Created by Stark on 2017/10/10.
 * 我们有一个栅栏，它有n个柱子，现在要给柱子染色，有k种颜色可以染。
 * 必须保证不存在超过2个相邻的柱子颜色相同，求有多少种染色方案。
 * 注意事项
 * n和k都是非负整数
 */
public class LintCode_514 {
    public int numWays(int n, int k) {
        // write your code here
        if (n == 0) return 0;
        if (n == 1) return k;
        if (n == 2) return k * k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] * (k - 1) + dp[i - 1] * (k - 1);
        }
        return dp[n - 1];
    }
}
