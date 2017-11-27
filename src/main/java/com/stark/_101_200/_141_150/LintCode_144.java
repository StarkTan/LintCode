package com.stark._101_200._141_150;

/**
 * Created by Stark on 2017/11/27.
 * 给出一个含有正整数和负整数的数组，重新排列成一个正负数交错的数组。
 */
public class LintCode_144 {
    public void rerange(int[] A) {
        // write your code here
        int len = A.length;
        int num1 = 0;
        int num2 = 0;
        for (int i : A) {
            if (i < 0) num2++;
            else num1++;
        }
        boolean need = num1 >= num2;
        for (int i = 0; i < len; i++) {
            if ((A[i] >= 0) == need) {
                need = !need;
            } else {
                boolean change = false;
                for (int j = i + 1; j < len; j++) {
                    if ((A[j] >= 0) == need) {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        need = !need;
                        change = true;
                        break;
                    }
                }
                if (!change) break;
            }
        }
    }
}
