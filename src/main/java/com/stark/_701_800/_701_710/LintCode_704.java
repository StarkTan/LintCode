package com.stark._701_800._701_710;

/**
 * Created by Stark on 2017/12/5.
 * 一个房间中有 n 盏灯最初是开着的，并且墙上有 4 个开关。
 * 在对开关进行 m 次未知的操作后，你需要返回这 n 盏灯有多少种不同的状态。
 * 1.将所有灯从开变成关，从关变成开。
 * 2.将标号为偶数的灯从开变成关，从关变成开。
 * 3.将标号为奇数的灯从开变成关，从关变成开。
 * 4.将标号为 (3k + 1) 的灯从开变成关，从关变成开，k = 0, 1, 2...
 */
public class LintCode_704 {
    public int flipLights(int n, int m) {
        // write your code here
        /**
         * 分析：n>3时
         *  m=1时 4中状态 1,2,3,4
         *  m=2因为 1,2->3 1,3->2 2,3->1 初始状态，1,4 2,4 3,4
         *  m=3    2 3 初始 4 3,4 2,4 1 1,4
         *
         */
        if (n == 0 || m == 0) return 1;
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            if (m == 1) return 2; // 1,2,3   4->1
            if (m >= 2) return 4; // 0,3,2,1
        }
        if (n >= 3) {
            if (m == 1) return 4;
            if (m == 2) return 7;
            if (m >= 3) return 8;
        }
        return 8;
    }
}
