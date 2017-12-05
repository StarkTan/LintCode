package com.stark._401_500._401_410;

/**
 * Created by Stark on 2017/12/4.
 * 在一个排序矩阵中找从小到大的第 k 个整数。
 * 排序矩阵的定义为：每一行递增，每一列也递增。
 */
public class LintCode_401 {

    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int len = matrix.length;
        int[] row = new int[len];
        int result = 0;
        for (int i = 0; i < k; i++) {
            int flag = 0;
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (row[j] < matrix[j].length) {
                    if (matrix[j][row[j]] < temp) {
                        temp = matrix[j][row[j]];
                        flag = j;
                    }
                }
            }
            row[flag]++;
            result = temp;
        }
        return result;
    }
}
