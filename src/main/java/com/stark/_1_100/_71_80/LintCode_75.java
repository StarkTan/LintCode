package com.stark._1_100._71_80;

/**
 * Created by Stark on 2017/12/4.
 * 你给出一个整数数组(size为n)，其具有以下特点：
 * 相邻位置的数字是不同的
 * A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 */
public class LintCode_75 {
    public int findPeak(int[] A) {
        // write your code here
        //感觉测试用例有问题
        int begin = 0;
        int end = A.length - 1;
        while (begin < end) {
            int mid = begin / 2 + end / 2;
            if (begin % 2 == 1 && end % 2 == 1) mid++;
            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) return mid;
            else if (A[mid] > A[mid + 1] && A[mid] < A[mid - 1]) end = mid;
            else begin = mid + 1;
        }
        return end;
    }
}
