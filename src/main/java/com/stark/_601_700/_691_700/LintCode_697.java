package com.stark._601_700._691_700;

/**
 * Created by Stark on 2017/10/20.
 * 待找答案
 */
public class LintCode_697 {
    public boolean checkSumOfSquareNumbers(int num) {
        // write your code here
        if (num < 0) {
            return false;
        }
        if (num < 2) {
            return true;
        }
        int one = 0;
        while (one * one < num) {
            int l = num - one * one;
            int two = 1;
            while (two * two <= l) {
                if (two * two == l) {
                    return true;
                } else {
                    two++;
                }
            }
            one++;
        }
        return false;
    }
}
