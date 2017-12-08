package com.stark._701_800._721_730;

/**
 * Created by Stark on 2017/12/6.
 */
public class LintCode_723 {

    public int leftRotate(int n, int d) {
        // write code here
        for (int i = 1; i <= d; i++) {
            n = n << 1 + n / (1 << 31);
        }
        return n;
    }

    public static void main(String[] args) {
        int i = new LintCode_723().leftRotate(123, 4);
        System.out.println(i);
    }
}
