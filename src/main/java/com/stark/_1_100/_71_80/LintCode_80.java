package com.stark._1_100._71_80;

import java.util.Arrays;

/**
 * Created by Stark on 2017/12/6.
 * <p>
 * TODO 使用快排找中位数
 */
public class LintCode_80 {

    public int median(int[] nums) {
        // write your code here

        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }
}
