package com.stark._401_500._431_440;

import com.stark._1_100._11_20.LintCode_13;

/**
 * Created by Stark on 2017/11/17.
 * 在一个二维01矩阵中找到全为1的最大正方形
 */
public class LintCode_436 {
    public int maxSquare(int[][] matrix) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == 0) continue;
                for (int k = i + 1; k < m; k++) {
                    if (matrix[k][j] != 0) matrix[i][j]++;
                    else break;
                }
            }
        }
        int res = 0;
        for (int[] aMatrix : matrix) {
            int solve = solve(aMatrix);
            res = Math.max(res, solve * solve);
        }
        return res;
    }

    //最大的正方形
    private int solve(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int height = nums[i];
            a:
            for (int j = height; j > 0; j--) {
                for (int k = i + j - 1; k > i; k--) {
                    if (k >= nums.length || nums[k] < j) continue a;
                }
                res = Math.max(res, j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_436 test = new LintCode_436();
        int[][] matix = new int[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        int i = test.maxSquare(matix);
        System.out.println(i);
    }

}
