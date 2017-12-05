package com.stark._401_500._401_410;

/**
 * Created by Stark on 2017/12/4.
 * 给定一个由 n 个正整数组成的数组和一个正整数 s ，
 * 请找出该数组中满足其和 ≥ s 的最小长度子数组。如果无解，则返回 -1。
 */
public class LintCode_406 {
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int len = nums.length;
        int res = len + 1;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= s) {
                    res = j - i + 1;
                }
                if (res <= j - i + 1) break;
            }
        }
        if (res == len + 1) return -1;
        else return res;
    }
}
