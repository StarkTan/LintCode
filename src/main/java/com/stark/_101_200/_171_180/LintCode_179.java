package com.stark._101_200._171_180;

/**
 * Created by Stark on 2017/12/1.
 */
public class LintCode_179 {
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        for (int pos = i; pos <= j; ++pos)
            n &= ~(1 << pos);
        m <<= i;
        return n | m;
    }
}
