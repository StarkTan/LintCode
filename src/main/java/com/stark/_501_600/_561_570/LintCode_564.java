package com.stark._501_600._561_570;

import java.util.Arrays;

/**
 * Created by Stark on 2017/11/27.
 * 给出一个都是正整数的数组 nums，其中没有重复的数。从中找出所有的和为 target 的组合个数。
 */
public class LintCode_564 {
    public int backPackVI(int[] nums, int target) {
        // write your code here
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j <= i; j++) {
                for (int cur : nums) {
                    if (cur == j) dp[i] += dp[i - j];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        LintCode_564 test = new LintCode_564();
        int i = test.backPackVI(new int[]{1, 2, 4}, 4);
        System.out.println(i);
    }
}
