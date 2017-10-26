package com.stark._301_400._371_380;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/21.
 * 给定一个包含 m x n 个要素的矩阵，（m 行, n 列），
 * 按照螺旋顺序，返回该矩阵中的所有要素。
 */
public class LintCode_374 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        boolean[][] visit = new boolean[m][n];
        int i = 0;
        int j = 0;
        visit[i][j] = true;
        res.add(matrix[i][j]);
        int cur = 1;
        while (cur < m * n) {
            //向左
            while (j + 1 < n && !visit[i][j + 1]) {
                j++;
                visit[i][j] = true;
                res.add(matrix[i][j]);
                cur++;
            }
            //向下
            while (i + 1 < m && !visit[i + 1][j]) {
                i++;
                visit[i][j] = true;
                res.add(matrix[i][j]);
                cur++;
            }
            //向右
            while (j - 1 >= 0 && !visit[i][j - 1]) {
                j--;
                visit[i][j] = true;
                res.add(matrix[i][j]);
                cur++;
            }
            //向上
            while (i - 1 >= 0 && !visit[i - 1][j]) {
                i--;
                visit[i][j] = true;
                res.add(matrix[i][j]);
                cur++;
            }
        }
        return res;
    }
}
