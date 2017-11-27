package com.stark._101_200._181_190;

/**
 * Created by Stark on 2017/11/27.
 * 如果要将整数A转换为B，需要改变多少个bit位？
 */
public class LintCode_181 {
    public int bitSwapRequired(int a, int b) {
        // write your code here
        int res = 0;
        if (a < 0 && b < 0) {
            a = a - Integer.MIN_VALUE;
            b = b - Integer.MIN_VALUE;
        }
        if (a < 0) {
            a = a - Integer.MIN_VALUE;
            res++;
        }
        if (b < 0) {
            b = b - Integer.MIN_VALUE;
            res++;
        }
        int num = a ^ b;
        while (num != 0) {
            if (num % 2 == 1) res++;
            num = num >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_181 test = new LintCode_181();
        int i = test.bitSwapRequired(1, -1);
        System.out.println(i);
    }
}
