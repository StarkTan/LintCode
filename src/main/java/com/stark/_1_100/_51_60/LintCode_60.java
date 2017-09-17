package com.stark._1_100._51_60;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 * 你可以假设在数组中无重复元素。
 */
public class LintCode_60 {
    public int searchInsert(int[] A, int target) {
        int begin = 0;
        int end = A.length - 1;
        int mid = (begin + end) / 2;
        while (begin < end) {
            if (A[mid] > target) {
                begin = mid + 1;
            } else if (A[mid] < target) {
                end = mid - 1;
            } else {
                return mid;
            }
            mid = (begin + end) / 2;
        }

        if (A[begin] >= target) {
            return begin;
        } else{
            return begin + 1;
        }
    }
}
