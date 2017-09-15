package com.stark._1_100._41_50;

import java.util.List;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个整数数组，找到一个具有最小和的子数组。返回其最小和。
 * 子数组最少包含一个数字
 */
public class LintCode_44 {
    public int minSubArray(List<Integer> nums) {
        // write your code here
        int min = Integer.MAX_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.size(); i++) {
            cur += nums.get(i);
            min = Math.min(cur, min);
            if (cur > 0) {
                cur = 0;
            }
        }
        return min;
    }
}
