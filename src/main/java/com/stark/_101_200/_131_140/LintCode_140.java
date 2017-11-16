package com.stark._101_200._131_140;

/**
 * Created by Stark on 2017/10/28.
 * 计算an % b，其中a，b和n都是32位的整数。
 */
public class LintCode_140 {
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 0)
            return 1 % b;
        else if (n == 1)
            return a % b;
        else if (n < 0)
            return -1;

        long product = fastPower(a, b, n/2);
        product = (product*product) % b;
        if (n % 2 == 1)
            product = (product * (a%b))%b; //equal: product = (product * a)%b;
        return (int)(product);
    }
}
