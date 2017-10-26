package com.stark._101_200._161_170;

/**
 * Created by Stark on 2017/10/23.
 * 给出 n，问由 1...n 为节点组成的不同的二叉查找树有多少种？
 */
public class LintCode_163 {
    public int numTrees(int n) {
        // write your code here
        if (n == 0) return 1;
        int[][] dp = new int[n][n];
        return solve(1, n, dp);
    }

    private int solve(int begin, int end, int[][] dp) {
        if (dp[begin - 1][end - 1] != 0) return dp[begin - 1][end - 1];
        if (begin == end) {
            dp[begin - 1][end - 1] = 1;
            return 1;
        }
        int res = 0;
        for (int i = begin; i <= end; i++) {
            if (i == begin) {
                res += solve(begin + 1, end, dp);
                continue;
            }
            if (i == end) {
                res += solve(begin, end - 1, dp);
                continue;
            }
            res += solve(begin, i - 1, dp) * solve(i + 1, end, dp);
        }
        dp[begin - 1][end - 1] = res;
        return res;
    }

    public static void main(String[] args) {
        LintCode_163 test = new LintCode_163();
        System.out.println(test.numTrees(19));
    }
}
