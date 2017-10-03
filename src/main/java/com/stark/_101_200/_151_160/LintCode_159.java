package com.stark._101_200._151_160;

/**
 * Created by Stark on 2017/10/3.
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 你可以假设数组中不存在重复的元素。
 */
public class LintCode_159 {
    public int findMin(int[] nums) {
        // write your code here
        int begin = 0;
        int end = nums.length - 1;
        if (nums[begin] < nums[end]) {
            return nums[begin];
        }
        while (begin < end) {
            int mid = (begin + end) / 2;
            if(nums[mid]>nums[end]){
                begin = mid+1;
            }else {
                end =mid;
            }
        }
        return nums[begin];
    }
}
