package com.stark._501_600._511_520;

/**
 * Created by Stark on 2017/10/8.
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )
 * 使得他们的和等于 n。你需要让平方数的个数最少。
 */
public class LintCode_513 {
    public int numSquares(int n) {
        // write your code here
        int[] dp = new int[n+1];
        if(n==0) return 0;
        dp[0] = 0;
        dp[1] = 1;
        int lastSquares = 1;
        for(int i=2;i<=n;i++){
            if(i == (lastSquares+1)*(lastSquares+1)){
                lastSquares ++;
                dp[i]=1;
            }else {
                int min =Integer.MAX_VALUE;
                int mid = i/2;
                for(int j=1;j<=mid;j++){
                    min = Math.min(min,dp[j]+dp[i-j]);
                }
                dp[i] =min;
            }
        }
        return dp[n];
    }
}
