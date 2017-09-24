package com.stark._101_200._181_190;

/**
 * Created by Stark on 2017/9/24.
 * 给定一个若干整数的排列，给出按正数大小进行字典序从小到大排序后的下一个排列。
 * 如果没有下一个排列，则输出字典序最小的序列。
 */
public class LintCode_190 {
    public void nextPermutation(int[] nums) {
        // write your code here
        int len = nums.length;
        int change = len;//改变点
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                change = i;
                break;
            }
        }
        if (change == len) {
            //全部反转
            myRevorse(0, len - 1, nums);
            return;
        }
        int upper = len;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > nums[change]) {
                upper = i;
                break;
            }
        }
        //交换
        int temp = nums[change];
        nums[change] = nums[upper];
        nums[upper] = temp;
        //部分倒转
        int begin = change + 1;
        int end = len - 1;
        myRevorse(begin, end, nums);
    }

    private void myRevorse(int begin, int end, int[] nums) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        LintCode_190 test = new LintCode_190();
        test.nextPermutation(new int[]{3,2,1});
    }
}
