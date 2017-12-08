package com.stark._601_700._691_700;

/**
 * Created by Stark on 2017/12/1.
 * 给一个 n 英寸长的杆子和一个包含所有小于等于 n 的尺寸的价格. 确定通过切割杆并销售碎片可获得的最大值.
 */
public class LintCode_700 {

    public int cutting(int[] prices, int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = prices[i - 1];
            for (int j = i - 1; j >= i / 2; j--) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LintCode_700 test = new LintCode_700();
        int cutting = test.cutting(new int[]{3, 5, 8, 9, 10, 17, 17, 20}, 8);
        System.out.println(cutting);
    }
}
