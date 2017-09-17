package com.stark._501_600._561_570;

/**
 * Created by Stark on 2017/9/17.
 * 给出一个非负整数 num，反复的将所有位上的数字相加，直到得到一个一位的整数。
 */
public class LintCode_569 {
    public int addDigits(int num) {
        /*if(num<0) return 0;
        if(num<10) return num;
        int res = 0;
        while(num>=10){
            res = res + num%10;
            num = num/10;
        }
        res = res + num;
        return addDigits(res); */

        if (num <= 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
