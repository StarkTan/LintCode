package com.stark._1_100._71_80;

/**
 * Created by Stark on 2017/9/22.
 * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 */
public class LintCode_76 {
    public int longestIncreasingSubsequence(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int res = 1;
        int[][] dp = new int[len][];
        dp[0] = new int[]{nums[0]};
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            dp[i] = new int[]{nums[i]};

            int l = 0;
            for (int j = 0; j < i; j++) {
                int[] dpb = dp[j];
                if (dpb[dpb.length - 1] < cur && l < dpb.length) {
                    l = dpb.length;
                    dp[i] = new int[l+1];
                    dp[i][l] = cur;
                    res = Math.max(l+1, res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_76 test = new LintCode_76();
        System.out.println(test.longestIncreasingSubsequence(new int[]{1, 2, 5, 4, 7}));
    }
}
