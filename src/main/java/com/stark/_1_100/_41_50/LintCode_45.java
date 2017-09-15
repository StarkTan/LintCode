package com.stark._1_100._41_50;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组和的差的绝对值|SUM(A) - SUM(B)|最大。
 * 返回这个最大的差值。
 * 注意事项
 * 子数组最少包含一个数
 */
public class LintCode_45 {
    public int maxDiffSubArrays(int[] nums) {
        int len = nums.length;
        int[] max_lefts = new int[len];
        max_lefts[0] = nums[0];
        int[] min_rights = new int[len];
        min_rights[len - 1] = nums[len - 1];
        int cur_max_left = nums[0] > 0 ? nums[0] : 0;
        int cur_min_right = nums[len - 1] < 0 ? nums[len - 1] : 0;

        int[] max_rights = new int[len];
        max_rights[len - 1] = nums[len - 1];
        int[] min_lefts = new int[len];
        min_lefts[0] = nums[0];

        int cur_max_right = nums[len - 1] > 0 ? nums[len - 1] : 0;
        int cur_min_left = nums[0] < 0 ? nums[0] : 0;

        for (int i = 1; i < len; i++) {
            cur_max_left += nums[i];
            max_lefts[i] = Math.max(max_lefts[i - 1], cur_max_left);
            cur_max_left = cur_max_left > 0 ? cur_max_left : 0;

            cur_min_right += nums[len - 1 - i];
            min_rights[len - i - 1] = Math.min(min_rights[len - i], cur_min_right);
            cur_min_right = cur_min_right < 0 ? cur_min_right : 0;

            cur_max_right += nums[len - 1 - i];
            max_rights[len - i - 1] = Math.max(max_rights[len - i], cur_max_right);
            cur_max_right = cur_max_right > 0 ? cur_max_right : 0;

            cur_min_left += nums[i];
            min_lefts[i] = Math.min(min_lefts[i - 1], cur_min_left);
            cur_min_left = cur_min_left < 0 ? cur_min_left : 0;
        }
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            res = Math.max(Math.max(Math.abs((max_lefts[i] - min_rights[i + 1])), res),
                    Math.max(Math.abs((min_lefts[i] - max_rights[i + 1])), res));
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new LintCode_45().maxDiffSubArrays(new int[]{-3, -1, 1, 3});
        System.out.println(i);
    }
}
