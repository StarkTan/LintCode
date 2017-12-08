package com.stark._701_800._721_730;

/**
 * Created by Stark on 2017/12/7.
 */
public class LintCode_722 {
    public int maxXorSubarray(int[] nums) {
        // write code here
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] ^ nums[i];
            if (dp[i] > res) res = dp[i];
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; i < len; j++) {
                dp[j] = dp[j] ^ nums[i];
                if (dp[j] > res) res = dp[j];
            }
        }
        return res;
    }
}
