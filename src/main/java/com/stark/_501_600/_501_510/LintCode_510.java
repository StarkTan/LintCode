package com.stark._501_600._501_510;

import java.util.Stack;

/**
 * Created by Stark on 2017/9/20.
 * 给你一个二维矩阵，权值为False和True，
 * 找到一个最大的矩形，使得里面的值全部为True，输出它的面积
 */
public class LintCode_510 {
    public int maximalRectangle(boolean[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        //对每一列统计
        int[][] record = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = j; k < m; k++) {
                    boolean b = matrix[k][i];
                    if (b) {
                        record[j][i]++;
                    } else {
                        break;
                    }
                }
            }
        }
        int res = 0;
        for (int j = 0; j < m; j++) {
            int[] numb = record[j];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= numb.length; i++) {
                int cur = i < numb.length ? numb[i] : 0;
                if (stack.isEmpty() || cur > numb[stack.peek()]) {
                    stack.push(i);
                } else {
                    int tem = stack.pop();
                    //关键步骤
                    res = Math.max(res, numb[tem] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                    i--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_510 test = new LintCode_510();
        boolean[] one = {true, false, true, true};
        boolean[] two = {true, true, false, true};
        boolean[] three = {true, true, true, true};
        boolean[][] ma = new boolean[][]{one, two, three};
        int i = test.maximalRectangle(ma);
        System.out.println(i);
    }
}