package com.stark._301_400._381_390;

/**
 * Created by Stark on 2017/9/21.
 * 给你一个数n生成一个包含1-n^2的螺旋形矩阵
 */
public class LintCode_381 {
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[0][];
        int total = n * n;
        int cur = 1;
        int i = 0;
        int j = 0;
        int[][] res = new int[n][n];
        res[i][j] = cur++;
        while (cur <= total) {
            //向下走一波
            while (true) {
                j++;
                if (j >= n || res[i][j] > 0) {
                    j--;
                    break;
                } else {
                    res[i][j] = cur++;
                }
            }
            //向右走一波
            while (true) {
                i++;
                if (i >= n || res[i][j] > 0) {
                    i--;
                    break;
                } else {
                    res[i][j] = cur++;
                }
            }
            //向上走一波
            while (true) {
                j--;
                if (j < 0 || res[i][j] > 0) {
                    j++;
                    break;
                } else {
                    res[i][j] = cur++;
                }
            }
            //向左走一波
            while (true) {
                i--;
                if (i < 0 || res[i][j] > 0) {
                    i++;
                    break;
                } else {
                    res[i][j] = cur++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_381 test = new LintCode_381();
        int[][] ints = test.generateMatrix(5);
        System.out.println(ints);
    }
}
