package com.stark._901_1000._991_1000;

import java.util.Arrays;

public class LintCode_992 {
    public int[] constructArray(int n, int k) {
        // Write your code here
        if (n <= 0 || k < 1 || k > n) return new int[0];
        int[] res = new int[n];
        res[0] = k != 1 ? k + 1 : 1;
        for (int i = 1; i <= k; i++) {
            res[i] = i % 2 == 0 ? res[i - 1] + (k - i + 1) : res[i - 1] - (k - i + 1);
        }
        for (int i = k != 1 ? k + 1 : 1; i < n; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LintCode_992().constructArray(3, 1)));
    }
}
