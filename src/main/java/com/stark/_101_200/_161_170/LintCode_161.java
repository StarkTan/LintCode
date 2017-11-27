package com.stark._101_200._161_170;

/**
 * Created by Stark on 2017/11/24.
 * 给定一个N×N的二维矩阵表示图像，90度顺时针旋转图像
 */
public class LintCode_161 {
    public void rotate(int[][] matrix) {
        // write your code here
        int n = matrix.length / 2;
        for (int i = 0; i < n; i++) {
            int begin = i;
            int end = matrix.length - 1 - i;
            int step = end - begin;
            for (int j = 0; j < step; j++) {
                int temp = matrix[begin][begin + j];
                matrix[begin][begin + j] = matrix[end - j][begin];
                matrix[end - j][begin] = matrix[end][end - j];
                matrix[end][end - j] = matrix[begin+j][end];
                matrix[begin+j][end] = temp;
            }
        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        LintCode_161 test = new LintCode_161();
        test.rotate(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }
}
