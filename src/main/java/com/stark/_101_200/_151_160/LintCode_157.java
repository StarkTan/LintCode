package com.stark._101_200._151_160;

/**
 * Created by Stark on 2017/10/30.
 * 实现一个算法确定字符串中的字符是否均唯一出现
 */
public class LintCode_157 {
    public boolean isUnique(String str) {
        // write your code here
        if (str == null) return true;
        for (int i = 0; i < str.length(); i++) {
            int i1 = str.indexOf(str.charAt(i));
            if (i1 != i) {
                return false;
            }
        }
        return true;
    }
}
