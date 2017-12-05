package com.stark._501_600._581_590;

/**
 * Created by Stark on 2017/12/4.
 * 给一 只含有正整数 的 非空 数组, 找到这个数组是否可以划分为 两个 元素和相等的子集。
 */
public class LintCode_588 {
    public boolean canPartition(int[] nums) {
        // write your code here
        int sum = 0;
        int len = nums.length;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) return false;
        int target = sum / 2;

        int[][] dp = new int[len][target + 1];

        for (int i = nums[0]; i <= target; i++) {
            dp[0][i] = nums[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = nums[i]; j <= target; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
            }
        }
        if (dp[len - 1][target] == target) return true;
        return false;
    }
}
