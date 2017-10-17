package com.stark._301_400._391_400;

import com.stark._401_500._491_500.LintCode_499;

import java.util.Map;

/**
 * Created by Stark on 2017/10/11.
 * 假设你是一个专业的窃贼，准备沿着一条街打劫房屋。每个房子都存放着特定金额的钱。
 * 你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
 * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，你最多可以得到多少钱 在不触动报警装置的情况下。
 * 给定 [3, 8, 4], 返回 8.
 */
public class LintCode_392 {
    public long houseRobber(int[] A) {
        // write your code here
        int len = A.length;
        long[] dp = new long[len];
        if (len == 0) return 0;
        if (len == 1) return A[0];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i]);
        }
        return dp[len - 1];
    }
}
