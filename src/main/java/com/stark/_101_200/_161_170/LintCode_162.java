package com.stark._101_200._161_170;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stark on 2017/10/2.
 * 给定一个m×n矩阵，如果一个元素是0，则将其所在行和列全部元素变成0。
 * 需要在原矩阵上完成操作。
 */
public class LintCode_162 {
    public void setZeroes(int[][] matrix) {
        // write your code here
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        Set<Integer> setM = new HashSet<>();
        Set<Integer> setN = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    setM.add(i);
                    setN.add(j);
                }
            }
        }
        for (Integer i : setM) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer j : setN) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
