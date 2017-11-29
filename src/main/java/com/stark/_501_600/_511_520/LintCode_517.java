package com.stark._501_600._511_520;

/**
 * Created by Stark on 2017/11/28.
 * 写一个程序来检测一个整数是不是丑数。
 * 丑数的定义是，只包含质因子 2, 3, 5 的正整数
 */
public class LintCode_517 {

    public boolean isUgly(int num) {
        // write your code here
        if (num <= 0) return false;
        while (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
            if (num % 2 == 0) {
                num = num / 2;
            }
            if (num % 3 == 0) {
                num = num / 3;
            }
            if (num % 5 == 0) {
                num = num / 5;
            }
        }
        return num == 1;
    }
}
