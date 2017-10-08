package com.stark._1_100._91_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/9.
 * 给一个整数数组，调整每个数的大小，使得相邻的两个数的差不大于一个给定的整数target，
 * 调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。
 * 你可以假设数组中每个整数都是正整数，且小于等于100。
 */
public class LintCode_91 {
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        int n = A.size();
        int[][] dp = new int[101][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 100; j++) {
                dp[j][i] = Integer.MAX_VALUE;
                int dif = Math.abs(j - A.get(i-1));
                int max = Math.min(100, j + target);
                int min = Math.max(0, j - target);
                for (int k = min; k <= max; k++) {
                    dp[j][i] = Math.min(dp[j][i], dp[k][i - 1] + dif);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 101; i++) {
            res = Math.min(res, dp[i][n]);
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_91 test = new LintCode_91();
        List<Integer> list = new ArrayList<>();
        int[] cases = new int[]{9,20,19,40};
        for (int i : cases) {
            list.add(i);
        }
        System.out.println(test.MinAdjustmentCost(list, 1));
    }

}
