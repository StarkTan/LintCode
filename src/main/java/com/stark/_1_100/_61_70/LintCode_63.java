package com.stark._1_100._61_70;

/**
 * Created by Stark on 2017/10/20.
 * 跟进“搜索旋转排序数组”，假如有重复元素又将如何？
 * 是否会影响运行时间复杂度？
 */
public class LintCode_63 {
    public boolean search(int[] A, int target) {
        // write your code here
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[mid] == A[left]) {
                left++;
                continue;
            }
            if (A[mid] < A[right]) {//右边上升序列
                if (target < A[mid] || target > A[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (A[mid] > A[left]) {
                if (target >= A[left] && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
