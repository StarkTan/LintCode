package com.stark._1_100._61_70;

/**
 * Created by Stark on 2017/9/16.
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 * 如果目标值不在数组中，则返回[-1, -1]
 */
public class LintCode_61 {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1, -1};
        int len = A.length;
        if (len == 0) {
            return res;
        }
        int begin = 0;
        int end = len - 1;
        if (A[begin] > target || A[end] < target) {
            return res;
        }
        while (begin <= end) {
            if (A[begin] != target) {
                begin++;
            }
            if (A[end] != target) {
                end--;
            }
            if (A[end] == target && A[begin] == target) {
                res[0] = begin;
                res[1] = end;
                break;
            }
        }
        return res;
    }
}
