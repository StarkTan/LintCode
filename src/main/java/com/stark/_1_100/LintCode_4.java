package com.stark._1_100;

/**
 * Created by Stark on 2017/8/28.
 * 设计一个算法，找出只含素因子2，3，5 的第 n 大的数。
 * 1是第一个丑数
 */
public class LintCode_4 {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int T2 = 0;
        int T3 = 0;
        int T5 = 0;
        for (int i = 1; i < n; i++) {
            int M2 = nums[T2]*2;
            int M3 = nums[T3]*3;
            int M5 = nums[T5]*5;
            int min = Math.min(Math.min(M2, M3), M5);
            if(M2==min) T2++;
            if(M3==min) T3++;
            if(M5==min) T5++;
            nums[i] = min;
        }
        return nums[n-1];
    }
    public static void main(String[] args) {
        System.out.println(new LintCode_4().nthUglyNumber(10000));
    }
}
