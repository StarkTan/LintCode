package com.stark._401_500._411_420;

/**
 * Created by Stark on 2017/12/5.
 */
public class LintCode_418 {
    public String intToRoman(int n) {
        // write your code here
        String digit[] = {"", "I", "II", "III", "IV", "V", "VI", "VII",
                "VIII", "IX"};
        String ten[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX",
                "XC"};
        String hundred[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC",
                "DCCC", "CM"};
        String thousand[] = {"", "M", "MM", "MMM"};
        String str = "";
        return str + thousand[n / 1000] + hundred[n % 1000 / 100] + ten[n % 100 / 10] + digit[n % 10];
    }
}
