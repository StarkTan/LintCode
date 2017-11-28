package com.stark._601_700._601_610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/11/28.
 * 给一个由 无重复的正整数 组成的集合，找出满足任意两个元素 (Si, Sj) 都有 Si % Sj = 0 或 Sj % Si = 0 成立的最大子集
 */
public class LintCode_603 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        if (nums.length == 0) return new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int[] parent = new int[len];
        Arrays.fill(parent, -1); //表示自己是一个集合
        int max = 1;
        int max_index = -1;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    if (dp[i] > max) {
                        max = dp[i];
                        max_index = i;
                    }
                }
            }
        }
        return solve(nums, parent, max_index);
    }

    private List<Integer> solve(int[] nums, int[] parent, int max_index) {
        List<Integer> res = new ArrayList<>();
        if (max_index == -1) {
            res.add(nums[0]);
            return res;
        }
        int item = max_index;
        while (item != -1) {
            res.add(nums[item]);
            item = parent[item];
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_603 test = new LintCode_603();
        List<Integer> list = test.largestDivisibleSubset(new int[]{1, 2, 3});
        System.out.println(list);
    }
}
