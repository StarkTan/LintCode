package com.stark._401_500._491_500;

/**
 * Created by Stark on 2017/9/17.
 * 判断一个正整数是不是回文数。
 * 回文数的定义是，将这个数反转之后，得到的数仍然是同一个数。
 */
public class LintCode_491 {
    public boolean palindromeNumber(int num) {
        String put = num + "";
        char[] arr = put.toCharArray();
        for (int i = 0; i <= (arr.length - 1) / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        String res = new String(arr);
        return res.equals(num + "");
    }
}
