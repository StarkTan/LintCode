package com.stark._301_400._391_400;

/**
 * Created by Stark on 2017/9/30.
 * 有 n 个不同价值的硬币排成一条线。两个参赛者轮流从左边依次拿走 1 或 2 个硬币，
 * 直到没有硬币为止。计算两个人分别拿到的硬币总价值，价值高的人获胜。
 * 请判定 第一个玩家 是输还是赢？
 */
public class LintCode_395 {
    public boolean firstWillWin(int[] values) {
        // write your code here
        int len = values.length;
        int[] dp = new int[len + 1];
        if (len < 3) return true;
        //边界条件
        dp[len] = 0;
        dp[len - 1] = values[len - 1];
        dp[len - 2] = values[len - 1] + values[len - 2];
        dp[len - 3] = values[len - 2] + values[len - 3];
        //循环
        for (int i = len - 4; i >= 0; i--) {
            int one = values[i] + Math.min(dp[i + 2], dp[i + 3]);
            int two = values[i] + values[i + 1] + Math.min(dp[i + 3], dp[i + 4]);
            dp[i] = Math.max(one, two);
        }
        //遍历求和
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return dp[0] >= sum - dp[0];
    }
}
