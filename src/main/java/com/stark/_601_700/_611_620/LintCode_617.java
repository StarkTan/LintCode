package com.stark._601_700._611_620;

import java.util.Arrays;

/**
 * Created by Stark on 2017/11/28.
 * 给出一个整数数组，有正有负。找到这样一个子数组，他的长度大于等于 k，且平均值最大。
 */
public class LintCode_617 {
    public double maxAverage(int[] nums, int k) {
        // write your code here
        double high = Integer.MIN_VALUE;
        double low = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > high) {
                high = nums[i];
            }
            if (nums[i] < low) {
                low = nums[i];
            }
        }

        while (high - low >= 1e-6) {
            double mid = (high + low) / 2.0;
            if (search(nums, k, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private boolean search(int[] nums, int k, double mid) {
        double min = 0;
        double[] sum = new double[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] - mid;
            if (i >= k && sum[i] >= min) {
                return true;
            }
            if (i >= k) {
                min = Math.min(min, sum[i - k + 1]);
            }
        }
        return false;
    }
}
