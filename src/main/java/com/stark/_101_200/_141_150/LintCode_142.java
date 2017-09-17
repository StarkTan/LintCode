package com.stark._101_200._141_150;

/**
 * Created by Stark on 2017/9/17.
 * 用 O(1) 时间检测整数 n 是否是 2 的幂次。
 */
public class LintCode_142 {
    public boolean checkPowerOf2(int n) {
        if(n<=0){
            return false;
        }
        if((n&(n+1))==0){
            return true;
        }else {
            return false;
        }
    }
}
