package com.stark._401_500._401_410;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stark on 2017/12/4.
 * 给定一个整数矩阵，请找出一个子矩阵，使得其数字之和等于0.输出答案时，请返回左上数字和右下数字的坐标
 */
public class LintCode_405 {

    public int[][] submatrixSum(int[][] matrix) {
        // write your code here
//        int m = matrix.length;
//        int[][] res = new int[2][2];
//        if (m == 0) return res;
//        int n = matrix[0].length;
//        int[][][][] four = new int[m][n][m][n];
//        for (int p = 0; p < m; p++) {
//            for (int q = 0; q < n; q++) {
//                for (int i = 0; i <= p; i++) {
//                    for (int j = 0; j <= q; j++) {
//                        int val = matrix[p][q];
//                        if (p > i) val += four[i][q][p - 1][q];
//                        if (q > j) val += four[p][j][p][q - 1];
//                        if (p > i && q > j) val += four[i][j][p - 1][q - 1];
//                        if (val == 0) return new int[][]{{i, j}, {p, q}};
//                        else four[i][j][p][q] = val;
//                    }
//                }
//            }
//        }
//        return res;


        int[][] result = new int[2][2];
        int M = matrix.length;
        if (M == 0) return result;
        int N = matrix[0].length;
        if (N == 0) return result;
        // pre-compute: sum[i][j] = sum of submatrix [(0, 0), (i, j)]
        int[][] sum = new int[M+1][N+1];
        for (int j=0; j<=N; ++j) sum[0][j] = 0;
        for (int i=1; i<=M; ++i) sum[i][0] = 0;
        for (int i=0; i<M; ++i) {
            for (int j=0; j<N; ++j)
                sum[i+1][j+1] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
        }
        for (int l=0; l<M; ++l) {
            for (int h=l+1; h<=M; ++h) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int j=0; j<=N; ++j) {
                    int diff = sum[h][j] - sum[l][j];
                    if (map.containsKey(diff)) {
                        int k = map.get(diff);
                        result[0][0] = l;   result[0][1] = k;
                        result[1][0] = h-1; result[1][1] = j-1;
                        return result;
                    } else {
                        map.put(diff, j);
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        LintCode_405 test = new LintCode_405();
        int[][] ints = test.submatrixSum(new int[][]{{1, 5, 7}, {3, 7, -8}, {4, -8, 9}});
        System.out.println(Arrays.deepToString(ints));
    }
}
