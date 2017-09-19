package com.stark._301_400._391_400;

import java.util.Arrays;

/**
 * Created by Stark on 2017/9/19.
 * 给定一个未经排序的数组，请找出其排序表中连续两个要素的最大间距。
 * 如果数组中的要素少于 2 个，请返回 0.
 */
public class LintCode_400 {
    //使用排序来解决
    public int minmumGap_V1(int[] nums) {
        int max = 0;
        if (nums.length < 2) {
            return max;
        }
        //可以使用线性时间排序来提升效率
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }
}
