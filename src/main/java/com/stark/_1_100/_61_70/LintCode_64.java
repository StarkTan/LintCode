package com.stark._1_100._61_70;

import java.util.Arrays;

/**
 * Created by Stark on 2017/11/28.
 */
public class LintCode_64 {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        for (int i = 0; i < n; i++) {
            A[m + i] = B[i];
        }
        Arrays.sort(A, 0, m + n);
    }
}
