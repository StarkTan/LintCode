package com.stark._301_400._361_370;

/**
 * Created by Stark on 2017/11/17.
 * 计算在一个 32 位的整数的二进制表示中有多少个 1.
 */
public class LintCode_365 {
    public int countOnes(int num) {
        // write your code here
        int res = 0;
        if (num < 0) {
            res++;
            num = num - Integer.MIN_VALUE;
        }
        while (num != 0) {
            if (num % 2 == 1) res++;
            num = num >> 1;
        }
        return res;
    }

    /**
     * 分析：将num-1与num做&操作将会去掉一个1，结果赋值给num，
     * 循环下去得到1的个数，若num中1的个数为m，则时间复杂度为O（m）。
     */
    public int countOnes_V1(int num) {
        // write your code here
        int res = 0;
        while (num != 0) {
            num = num & (num - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_365 test = new LintCode_365();
        int i = test.countOnes(-1);
        System.out.println(i);
    }
}
