package com.stark._101_200._101_110;

import java.util.Arrays;

/**
 * Created by Stark on 2017/10/10.
 * 跟进“删除重复数字”：
 * 如果可以允许出现两次重复将如何处理？
 */
public class LintCode_101 {
    public int removeDuplicates(int[] nums) {
        // write your code here
        int res = 0;
        int time = 1;
        for (int i : nums) {
            if (i == Integer.MAX_VALUE) {
                if (time == 1) {
                    time++;
                } else if (time == 2) {
                    time = 1;
                    break;
                }
                res++;
            }
        }
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int cur = nums[begin];
            if (cur == Integer.MAX_VALUE) {
                begin++;
            } else {
                res++;
                for (int i = begin + 1; i <= end; i++) {
                    if (nums[i] == cur) {
                        if (time == 1) {
                            time++;
                            res++;
                        } else if (time == 2) {
                            nums[i] = Integer.MAX_VALUE;
                        }
                    }
                }
                begin += time;
                time = 1;
            }
        }
        Arrays.sort(nums);
        return res;
    }
}
