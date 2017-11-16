package com.stark._601_700._661_670;

/**
 * Created by Stark on 2017/10/28.
 * 给一 二维矩阵,计算由左上角 (row1, col1) 和右下角 (row2, col2) 划定的矩形内元素和.
 * TODO 溢出毫无办法
 */
public class LintCode_665 {
    private int[][] map = null;

    public LintCode_665(int[][] matrix) {
        // do intialization if necessary
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] map = new int[m + 1][n + 1];
        this.map = map;
        for (int i = 1; i <= m; i++) {
            int cur = 0;
            for (int j = 1; j <= n; j++) {
                cur = matrix[i - 1][j - 1] + cur;
                map[i][j] = map[i - 1][j] + cur;
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return map[row2][col2] - map[row1][col2] - map[row2][col1] + map[row1][col1];
    }
}
