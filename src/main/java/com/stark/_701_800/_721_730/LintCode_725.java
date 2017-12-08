package com.stark._701_800._721_730;

import com.stark._601_700._621_630.LintCode_622;

/**
 * Created by Stark on 2017/12/7.
 */
public class LintCode_725 {

    public int countParenth(char[] symb, char[] oper) {
        // write your code here
        int len = symb.length;
        int[][] dp_true = new int[len][len];
        int[][] dp_false = new int[len][len];
        for (int i = 0; i < len; i++) {
            char c = symb[i];
            if (c == 'T') dp_true[i][i] = 1;
            if (c == 'F') dp_false[i][i] = 1;
        }
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                for (int k = i; k < j; k++) {
                    char c = oper[k];
                    if (c == '&') {
                        dp_true[i][j] +=
                                dp_true[i][k] * dp_true[k + 1][j];
                        dp_false[i][j] +=
                                dp_false[i][k] * dp_false[k + 1][j] +
                                        dp_false[i][k] * dp_true[k + 1][j] +
                                        dp_true[i][k] * dp_false[k + 1][j];
                    }
                    if (c == '|') {
                        dp_false[i][j] +=
                                dp_false[i][k] * dp_false[k + 1][j];
                        dp_true[i][j] +=
                                dp_true[i][k] * dp_true[k + 1][j] +
                                        dp_false[i][k] * dp_true[k + 1][j] +
                                        dp_true[i][k] * dp_false[k + 1][j];
                    }
                    if (c == '^') {
                        dp_false[i][j] +=
                                dp_false[i][k] * dp_false[k + 1][j] +
                                        dp_true[i][k] * dp_true[k + 1][j];
                        dp_true[i][j] +=
                                dp_false[i][k] * dp_true[k + 1][j] +
                                        dp_true[i][k] * dp_false[k + 1][j];
                    }
                }
            }
        }
        return dp_true[0][len - 1];
    }

    public static void main(String[] args) {
        LintCode_725 test = new LintCode_725();
        int i = test.countParenth(new char[]{'T', 'F', 'T'}, new char[]{'^', '&'});
        System.out.println(i);
    }
}
