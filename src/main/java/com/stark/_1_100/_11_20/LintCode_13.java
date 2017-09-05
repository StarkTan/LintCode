package com.stark._1_100._11_20;

/**
 * Created by Stark on 2017/9/4.
 * 对于一个给定的 source 字符串和一个 target 字符串，
 * 你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 */
public class LintCode_13 {
    //暴力匹配
    public int strStr_V1(String source, String target) {
        if (source == null || target == null
                || target.length() > source.length()) {
            return -1;
        }
        if(target.equals("")){
            return 0;
        }
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        one:
        for (int i = 0; i <= s.length - t.length; i++) {
            if (s[i] == t[0]) {
                for (int j = 1; j < t.length; j++) {
                    if (s[i + j] != t[j]) {
                        continue one;
                    }
                }
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int i = new LintCode_13().strStr_V1("1123123", "4");
        System.out.println(i);
    }
}
