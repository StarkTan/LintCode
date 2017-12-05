package com.stark._101_200._141_150;

/**
 * Created by Stark on 2017/12/4.
 */
public class LintCode_141 {

    public int sqrt(int x) {
        // write your code here
        int begin = 0;
        int end = x;
        while (begin <= end) {
            int mid = begin / 2 + end / 2;
            if (begin % 2 == 1 && end % 2 == 1) mid++;
            long value = (long)mid * (long)mid;
            if (value == x) return mid;
            else if (value < x) begin = mid + 1;
            else end = mid - 1;
        }

        if ((long)begin * (long)begin < x) return begin;
        else return --begin;
    }

    public static void main(String[] args) {
        LintCode_141 test = new LintCode_141();
        int sqrt = test.sqrt(2147483647);
        System.out.println(sqrt);
    }
}
