package com.stark._1_100._21_30;

/**
 * Created by Stark on 2017/9/7.
 * 写出一个高效的算法来搜索 m × n矩阵中的值。
 * 这个矩阵具有以下特性：
 * 每行中的整数从左到右是排序的。
 * 每行的第一个数大于上一行的最后一个整数。
 */
public class LintCode_28 {
    //正解
    public boolean searchMatrix_V1(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        //向下寻找行
        int y = 0;
        while (true) {
            if (y >= n) return false;
            int cur = matrix[m - 1][y];
            if (cur > target) {
                break;
            } else if (cur == target) {
                return true;
            } else {
                y = y + 1;
            }
        }
        int x = m - 1;
        while (true) {
            if (x < 0) {
                return false;
            }
            int cur = matrix[x][y];
            if (cur > target) {
                x--;
            } else {
                return cur == target;
            }
        }
    }

    //不过lintcode方向反了
    public boolean searchMatrix_V2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        //向下寻找行
        int x = 0;
        while (true) {
            if (x >= m) return false;
            int cur = matrix[x][n-1];
            if (cur > target) {
                break;
            } else if (cur == target) {
                return true;
            } else {
                x = x + 1;
            }
        }
        int y = n - 1;
        while (true) {
            if (y < 0) {
                return false;
            }
            int cur = matrix[x][y];
            if (cur > target) {
                y--;
            } else {
                return cur == target;
            }
        }

    }

    public static void main(String[] args) {
        int[][] p = new int[4][3];
        p[0] = new int[]{1, 10, 23};
        p[1] = new int[]{3, 11, 30};
        p[2] = new int[]{5, 16, 34};
        p[3] = new int[]{7, 20, 50};
        System.out.println(new LintCode_28().searchMatrix_V1(p, 0));
    }
}
