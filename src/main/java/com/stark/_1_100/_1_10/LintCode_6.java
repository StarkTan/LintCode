package com.stark._1_100._1_10;

/**
 * Created by Stark on 2017/9/1.
 * 合并两个排序的整数数组A和B变成一个新的数组。
 */
public class LintCode_6 {
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int totalLen = A.length + B.length;
        int[] res = new int[totalLen];
        int a = 0;
        int b = 0;
        for (int i = 0; i < totalLen; i++) {
            if (a == A.length) {
                for (; b < B.length; b++) {
                    res[i] = B[b];
                    i++;
                }
                break;
            }
            if (b == B.length) {
                for (; a < A.length; a++) {
                    res[i] = A[a];
                    i++;
                }
                break;
            }
            if (A[a] < B[b]) {
                res[i] = A[a];
                a++;
            } else {
                res[i] = B[b];
                b++;
            }
        }
        return res;
    }
}
