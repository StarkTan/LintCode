package com.stark._701_800._701_710;

import java.util.Arrays;

/**
 * Created by Stark on 2017/10/19.
 * 给一个长度为 n 的数组 nums 和一个长度为 k 的数组 req, 你需要根据要求折叠数组，并输出折叠的结果
 */
public class LintCode_703 {
    public int[] folding(int[] nums, int[] req) {
        // write your code here
        if (req.length == 0) {
            return nums;
        }
        for (int i = 0; i < req.length; i++) {
            nums = solve(nums, req[i], i);
        }
        return nums;
    }

    private int[] solve(int[] nums, int value, int cur) {
        int len = nums.length;
        int period = len;
        for (int i = 0; i <= cur; i++) {
            period = period / 2;
        }
        int time = value;
        int[] res = new int[len];
        int begin = 0;
        int end = len - 1;
        for (int i = len - 1; i >= 0; i = i - period) {
            for (int j = i; j > i - period; j--) {
                if (time % 2 == 0) { //从后向前
                    res[end--] = nums[j];
                } else {//从前向后
                    res[begin++] = nums[j];
                }
            }
            time++;
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_703 test = new LintCode_703();
        int[] folding = test.folding(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{0, 0, 1});
        System.out.println(Arrays.toString(folding));
    }
}
