package com.stark._401_500._411_420;

/**
 * Created by Stark on 2017/10/20.
 * 将一个整数中的数字进行颠倒，当颠倒后的整数溢出时，返回 0
 */
public class LintCode_413 {
    public int reverseInteger(int n) {
        // write your code here
        StringBuilder res;
        if (n < 0) {
            res = new StringBuilder();
            res.append(n);
            res.append("-");
            res.reverse();
            res.deleteCharAt(res.length() - 1);
        } else {
            res = new StringBuilder((n+""));
            res.reverse();
        }
        Long l = new Long(res.toString());
        if(l>Integer.MAX_VALUE||l<Integer.MIN_VALUE){
            return 0;
        }else {
            return Math.toIntExact(l);
        }
    }
}
