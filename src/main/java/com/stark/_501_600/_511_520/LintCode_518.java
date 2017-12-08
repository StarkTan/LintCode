package com.stark._501_600._511_520;

/**
 * Created by Stark on 2017/12/6.
 * 写一个程序来找第 n 个超级丑数。
 * <p>
 * 超级丑数的定义是正整数并且所有的质数因子都在所给定的一个大小为 k 的质数集合内。
 */
public class LintCode_518 {


    public int nthSuperUglyNumber(int n, int[] primes) {
        // write your code here
        int[] dp = new int[n];
        dp[0] = 1;
        int len = primes.length;
        int[] index = new int[len];
        int pos = 1;
        while (pos < n) {
            int primes_index = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                int cur = primes[i] * dp[index[i]];
                if (cur < min) {
                    primes_index = i;
                    min = cur;
                }
            }
            index[primes_index]++;
            if(dp[pos-1]!=min){
                dp[pos++] = min;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        LintCode_518 lintCode_518 = new LintCode_518();
        int i = lintCode_518.nthSuperUglyNumber(6, new int[]{2, 7, 13, 19});
        System.out.println(i);
    }

}
