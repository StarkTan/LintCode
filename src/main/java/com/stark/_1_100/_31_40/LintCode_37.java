package com.stark._1_100._31_40;

/**
 * 反转一个只有3位数的整数。
 * 你可以假设输入一定是一个只有三位数的整数，这个整数大于等于100，小于1000。
 */
public class LintCode_37 {
    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        int res = 0;
        if (number < 100 || number >= 1000) {
            return res;
        }
        res += number / 100;
        number %= 100;
        res += number / 10 * 10;
        number %= 10;
        res += number * 100;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_37().reverseInteger(809));
        System.out.println(new LintCode_37().reverseInteger(100));
        System.out.println(new LintCode_37().reverseInteger(134));
        System.out.println(new LintCode_37().reverseInteger(123));
    }
}
