package com.stark._401_500._401_410;

/**
 * Created by Stark on 2017/9/28.
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 */
public class LintCode_408 {
    public String addBinary(String a, String b) {
        // write your code here
        int ia = Integer.parseInt(a, 2);
        int ib = Integer.parseInt(b, 2);
        int res = ia+ib;
        return Integer.toBinaryString(res);
    }
}
