package com.stark._501_600._561_570;

/**
 * Created by Stark on 2017/12/4.
 * 给一个由 1 - n 的整数随机组成的一个字符串序列，其中丢失了一个整数，请找到它。
 * TODO 算法不正确
 */
public class LintCode_570 {
    public int findMissing2(int n, String str) {
        // write your code here
        for (int i = 1; i <= n; i++) {
            String tar = i + "";
            if (!str.contains(tar)) return i;
        }
        return 0;
    }
}
