package com.stark._401_500._401_410;

/**
 * Created by Stark on 2017/10/9.
 * 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。
 * 该数字按照大小进行排列，最大的数在列表的最前面。
 * 给定 [1,2,3] 表示 123, 返回 [1,2,4].
 * 给定 [9,9,9] 表示 999, 返回 [1,0,0,0].
 */
public class LintCode_407 {
    public int[] plusOne(int[] digits) {
        // write your code here
        int len = digits.length;
        digits[len - 1]++;
        boolean ifNewArr = false;
        for (int i = len - 1; i >= 0; i--) {
            if (i != 0) {
                if (digits[i] >= 10) {
                    digits[i - 1]++;
                    digits[i] = 0;
                }else {
                    return  digits;
                }
            }else {
                if (digits[i] == 10) {
                    digits[i] = 0;
                    int[] newArr = new int[len+1];
                    newArr[0] = 1;
                    System.arraycopy(digits, 0, newArr, 1, len);
                    return newArr;
                }else {
                    return  digits;
                }
            }
        }
        return digits;
    }
}
