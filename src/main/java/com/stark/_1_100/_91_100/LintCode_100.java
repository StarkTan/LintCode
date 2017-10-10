package com.stark._1_100._91_100;

import java.util.Arrays;

/**
 * Created by Stark on 2017/10/10.
 * 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。
 * 不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
 */
public class LintCode_100 {
    public int removeDuplicates(int[] nums) {
        // write your code here
        int res = 0;
        for (int i : nums) {
            if (i == Integer.MAX_VALUE) {
                res++;
                break;
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
                        nums[i] = Integer.MAX_VALUE;
                    }
                }
                begin++;
            }
        }
        Arrays.sort(nums);
        return res;
    }
}
