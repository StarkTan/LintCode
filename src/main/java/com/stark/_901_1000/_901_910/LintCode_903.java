package com.stark._901_1000._901_910;

public class LintCode_903 {
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] res = new int[length];
        for (int[] ints : updates) {
            for (int i = ints[0]; i <= ints[1]; i++) {
                res[i] += ints[2];
            }
        }
        return res;
    }
}
