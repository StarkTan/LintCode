package com.stark._601_700._601_610;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_608 {
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int one = nums[i];
            if (one >= target) return res;
            for (int j = i + 1; j < nums.length; j++) {
                int two = nums[j];
                if (one + two == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
                if (one + two > target) break;
            }
        }
        return res;
    }
}
