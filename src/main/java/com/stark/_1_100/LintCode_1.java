package com.stark._1_100;

/**
 * Created by Stark on 2017/8/28.
 *# 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符
 */
public class LintCode_1 {
    public int aplusb(int a, int b) {
        if(a==0||b==0) return b==0?a:b;
        int or = a^b;
        int and_1 = (a&b)<<1;
        return aplusb(or,and_1);
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_1().aplusb(23,18));
}
}
