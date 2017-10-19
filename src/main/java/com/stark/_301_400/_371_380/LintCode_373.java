package com.stark._301_400._371_380;

import java.util.Arrays;

/**
 * Created by Stark on 2017/10/19.
 * 分割一个整数数组，使得奇数在前偶数在后。
 */
public class LintCode_373 {
    public void partitionArray(int[] nums) {
        // write your code here
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            if (nums[begin] % 2 == 0) {
                int temp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = temp;
                end--;
            }else {
                begin++;
            }
        }
    }

    public static void main(String[] args) {
        LintCode_373 test = new LintCode_373();
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10};
        test.partitionArray(ints);
        System.out.println(Arrays.toString(ints));
    }
}
