package com.stark._1_100._91_100;

/**
 * Created by Stark on 2017/10/20.
 * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 */
public class LintCode_92 {
    //可优化
    public int backPack_V1(int m, int[] A) {
        int[][] dp = new int[A.length][m + 1];//动态规划矩阵
        for(int i = 0; i < A.length; i ++) {//背包空间为0时，不管要放第几个物品，可装满的背包空间为0.
            dp[i][0] = 0;
        }
        for(int j = 1; j < m + 1; j++) {
            if(A[0] <= j) {//当第0个物品的空间小于等于当前背包空间j时
                dp[0][j] = A[0];//背包可装满的最大空间是第0个物品的体积
            }else {//当第0个物品的空间大于当前背包空间j时
                dp[0][j] = 0;//背包可装满的最大空间是0
            }
            for(int i = 1; i < A.length; i++) {//当放第1个到第A.length-1个物品时
                if(A[i] > j) {//若该物品所占空间大于背包总空间（无论怎样腾背包空间，该物品无法放入背包
                    dp[i][j] = dp[i - 1][j];//背包可装满的最大空间不变
                }else {//若该物品所占空间小于等于背包总空间,则需将背包空间腾出至少A[i]后，将该物品放入。放入新物品后背包最大可装满空间可能更大，也可能变小大，取大值作为背包空间为j且放第i个物品时可以有的最大可装满空间。
                    dp[i][j] = Math.max(dp[i-1][j - A[i]] + A[i], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length - 1][m];
    }
    public int backPack_V2(int m, int[] A) {
        int f[] = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + A[i]);
            }
        }
        return f[m];
    }

    public static void main(String[] args) {
        LintCode_92 test = new LintCode_92();
        System.out.println(test.backPack_V2(10,new int[]{2,3,5,7}));
    }
}
