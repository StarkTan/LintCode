package com.stark._1_100._51_60;

/**
 * Created by Stark on 2017/9/15.
 * 实现atoi这个函数，将一个字符串转换为整数。
 * 如果没有合法的整数，返回0。
 * 如果整数超出了32位整数的范围，
 * 返回INT_MAX(2147483647)如果是正整数，或者INT_MIN(-2147483648)如果是负整数。
 */
public class LintCode_54 {
    public int atoi(String str) {
        if (null == str || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        int len = str.length();
        boolean negative = false;
        char first = str.charAt(0);
        int limit = -Integer.MAX_VALUE;
        int i = 0;
        if (!between(first)) {
            if (first == '-') {
                negative = true;
                limit = Integer.MIN_VALUE;
            } else if (first != '+') {
                return 0;
            }
            i = 1;
        }
        int result = 0;
        while (i < len) {
            char c = str.charAt(i);
            if (!between(c)) {
                break;
            } else {
                result = result * 10;
                int next = c - '0';
                if (result < limit / 10 || result < limit + next) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= next;
            }
            i++;
        }
        return negative ? result : -result;
    }

    //判断字符是否在0-9间
    private boolean between(char c) {
        int num = c - '0';
        if (num >= 0 && num <= 9) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int atoi = new LintCode_54().atoi("12312312312");
        System.out.println(atoi);
        //Integer.parseInt("12312312312");
    }
}
