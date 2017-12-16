package com.stark._401_500._421_430;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_428 {
    public double myPow(double x, int n) {
        // write your code here

        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 0;
            }
            x = 1 / x;
            n = -n;
        }
        double one = 1;
        double two = x;
        while (n / 2 > 0) {
            if (n % 2 == 1) one *= two;
            two *= two;
            n = n >> 1;
        }
        return one * two;
    }

    public static void main(String[] args) {
        double v = new LintCode_428().myPow(3, 3);
        System.out.println(v);
    }
}
