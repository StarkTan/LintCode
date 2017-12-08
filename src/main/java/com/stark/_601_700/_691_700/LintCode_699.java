package com.stark._601_700._691_700;

/**
 * Created by Stark on 2017/12/6.
 * 给两个数字 n 和 k. 我们需要判断 n 是否可以写成 k 个素数的和.
 */
public class LintCode_699 {
    /**
     * 思路：
     * 利用哥德巴赫猜想得出，任何大于2的偶数可以分解为两个质数的和。
     * 由于最小的素数为2，当n<2k时，不可能实现，返回false；
     * 当n为偶数，
     * <p>
     * 若k也为偶数（k=2q），n>=4q，n可以分成q个大于等于4的数，根据猜想，每个数又可以表示为两个质数的和，故可以表示为k（即2q）个质数的和，返回true。
     * 若k为奇数，为了保证n可以是k个数的和，必存在素数2，返回isSumOfKPrimes(n - 2, k - 1)。
     * 当n为奇数，
     * <p>
     * 若k为偶数，n不可能由偶数个奇数组成，必存在素数2，返回isSumOfKPrimes(n - 2, k - 1)。
     * 若k为奇数，必然存在至少一个奇数，返回isSumOfKPrimes(n - 3, k - 1)
     */
    public boolean isSumOfKPrimes(int n, int k) {
        // write your code here
        if (n < 2 * k || k <= 0)
            return false;
        if (k == 1)
            return isPrime(n);
        if (n % 2 == 0) {
            if (k % 2 == 0)
                return true;
            else
                return isSumOfKPrimes(n - 2, k - 1);
        } else {
            if (k % 2 == 0)
                return isSumOfKPrimes(n - 2, k - 1);
            else
                return isSumOfKPrimes(n - 3, k - 1);
        }

    }

    private boolean isPrime(int n) {

        if (n < 2)
            return false;
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
