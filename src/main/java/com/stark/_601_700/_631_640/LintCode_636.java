package com.stark._601_700._631_640;

/**
 * Created by Stark on 2017/11/27.
 * 给你一个 n 个整数的序列 a1,a2,...,an，一个 132 模式是对于一个子串 ai,aj,ak，
 * 满足 i < j < k 和 ai < ak < aj。设计一个算法来检查输入的这 n 个整数的序列中是否存在132模式。
 * n 会小于 20,000。
 */
public class LintCode_636 {

    public boolean find132pattern(int[] nums) {

        int len = nums.length;
        if (len < 3) return false;
        int max = Math.max(nums[1], nums[0]);
        int min = Math.min(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int cur = nums[i];
            if (cur > min && cur < max) return true;
            max = Math.max(max, cur);
            min = Math.min(min, cur);
        }
        return false;
    }
}
