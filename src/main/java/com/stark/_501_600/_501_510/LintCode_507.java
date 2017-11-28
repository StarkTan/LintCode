package com.stark._501_600._501_510;

import java.util.Arrays;

/**
 * Created by Stark on 2017/11/28.
 */
public class LintCode_507 {
    public void wiggleSort(int[] nums) {
        // write your code here
        int[] temp = Arrays.copyOf(nums, nums.length);

        Arrays.sort(temp);
        int n = nums.length;
        int k = (n + 1) / 2;
        int j = n;
        for (int i = 0; i < n; ++i) {
            nums[i] = i % 2 == 1 ? temp[--j] : temp[--k];
        }
    }
}
