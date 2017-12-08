package com.stark._701_800._721_730;

/**
 * Created by Stark on 2017/12/6.
 */
public class LintCode_721 {
    public int nextSparseNum(int x) {
        // write your code here
        while ((x & (x << 1)) != 0) {
            int d1 = x & (x << 1);
            while ((d1 & (d1 - 1)) != 0) {
                d1 = d1 & (d1 - 1);
            }
            x = (x + d1 - 1) & (~(d1 - 1));
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(new LintCode_721().nextSparseNum(38));
    }
}
