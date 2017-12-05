package com.stark._701_800._721_730;

/**
 * Created by Stark on 2017/12/5.
 */
public class LintCode_729 {

    public int computeLastDigit(long A, long B) {
        // write your code here
        int res = 1;
        for (long i = B; i > A; i--) {
            res = ((int) (i % 10) * res) % 10;
            if(res==0) return 0;
        }
        return res;
    }
}
