package com.stark._401_500._411_420;

/**
 * Created by Stark on 2017/10/11.
 * 将两个整数相除，要求不使用乘法、除法和 mod 运算符。
 * 如果溢出，返回 2147483647 。
 */
public class LintCode_414 {

    public int divide(int dividend, int divisor) {

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean nav = false;
        if (dividend < 0) {
            nav = true;
        } else {
            dividend = -dividend;
        }
        if (divisor < 0) {
            nav = !nav;
        } else {
            divisor = -divisor;
        }
        int res = 0;
        int rate = 1;
        int divisorCopy = divisor;
        while (dividend <= divisor) {
            if (dividend < divisorCopy) {
                res = res - rate;
                rate++;
                dividend = dividend - divisorCopy;
                divisorCopy += divisor;
            } else if (dividend == divisorCopy) {
                res = res - rate;
                break;
            } else {
                divisorCopy = divisor;
                rate = 1;
            }
        }
        if (res == Integer.MIN_VALUE && !nav) return Integer.MAX_VALUE;
        return nav ? res : -res;
    }

    public static void main(String[] args) {
        LintCode_414 test = new LintCode_414();
        int divide = test.divide(10, 2);
        System.out.println(divide);
    }
}
