package com.stark._401_500._411_420;

/**
 * Created by Stark on 2017/10/20.
 * 给定一个罗马数字，将其转换成整数。
 * 返回的结果要求在1到3999的范围内。
 */
public class LintCode_419 {
    public int romanToInt(String s) {
        // write your code here
        int[] tagVal = new int[256];
        tagVal['I'] = 1;
        tagVal['V'] = 5;
        tagVal['X'] = 10;
        tagVal['C'] = 100;
        tagVal['M'] = 1000;
        tagVal['L'] = 50;
        tagVal['D'] = 500;

        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 >= s.length() || tagVal[s.charAt(i + 1)] <= tagVal[s.charAt(i)])
                val += tagVal[s.charAt(i)];
            else
                val -= tagVal[s.charAt(i)];
        }
        return val;
    }
}
