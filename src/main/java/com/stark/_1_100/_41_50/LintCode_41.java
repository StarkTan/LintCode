package com.stark._1_100._41_50;

/**
 * Created by Stark on 2017/9/14.
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 */
public class LintCode_41 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curMax = 0;
        for (int i = 0; i < nums.length; i++) {
            curMax += nums[i];
            max = Math.max(curMax, max);
            if(curMax<0){
                curMax=0;
            }
        }
        return max;
    }
}
