package com.stark._1_100._81_90;
/**
 * Created by Stark on 2017/10/10.
 * 给定n个不同的正整数，整数k（k < = n）以及一个目标数字。
 * 在这n个数里面找出K个数，使得这K个数的和等于目标数字，求问有多少种方案？
 */
public class LintCode_89 {
    public int kSum(int[] A, int k, int target) {
        // write your code here
        /*int len = A.length;
        //动态规划dp(i , j , k)表示前i个数字中找出j个数，使得这 j 个数的和等于 k 的方案数。
        int[][][] dp = new int[len+1][k+1][target+1];
        for(int i=0;i<len;++i)
            if(A[i]<=target)
                for(int j=i+1;j<=len;++j)
                    dp[j][1][A[i]] = 1;
        for(int i=1;i<=len;++i)
            for(int j=2;j<=k&&j<=i;++j)
                for(int s=1;s<=target;++s)
                    //前i-1个数完成目标 和 必须加上 i 才能完成目标
                    //dp(i, j, k) = dp(i-1, j, k) + dp(i-1, j-1, k-input[ i ])。（即取与不取第j个数的方案数之和，类似于01背包）
                    dp[i][j][s] = dp[i-1][j][s] + (s>A[i-1]?dp[i-1][j-1][s-A[i-1]]:0);

        return dp[len][k][target];*/
        //由上式引出的优化
        int len = A.length;
        //动态规划dp(j , k)使用j 个数的和等于 k 的方案数
        int[][] dp = new int[k + 1][target + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= len; ++i) {
            for (int j = k; j >= 1; j--)
                for (int s = target; s >= A[i - 1]; --s)
                    //[j-1][k-arr[i]] 满足的集合
                    dp[j][s] += dp[j - 1][s - A[i - 1]];
        }

        return dp[k][target];
    }

    private int solve(int[] a, int k, int targer, int begin) {
        int result = 0;
        if (k == 1) {
            for (int i = begin; i <= a.length - 1; i++) {
                if (a[i] == targer) {
                    result = result + 1;
                }
                if (a[i] > targer) {
                    break;
                }
            }
        } else if (k > 1) {
            for (int i = begin; i < a.length - 1; i++) {
                if (a[i] < targer) {
                    result += solve(a, k - 1, targer - a[i], i + 1);
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
