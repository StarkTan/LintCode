package com.stark._101_200._171_180;

/**
 * Created by Stark on 2017/11/28.
 */
public class LintCode_172 {

    public int removeElement(int[] A, int elem) {
        // write your code here
        int res = 0;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                res++;
                A[j++] = A[i];
            }
        }
        return res;
    }
}
