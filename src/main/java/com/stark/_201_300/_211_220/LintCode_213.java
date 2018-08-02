package com.stark._201_300._211_220;

public class LintCode_213 {

    public String compress(String str) {
        // write your code here
        int len = str.length();
        if (len < 1) return str;
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char cur = chars[0];
        int num = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] == cur) {
                num++;
            } else {
                sb.append(cur).append(num);
                cur = chars[i];
                num = 1;
            }
        }
        sb.append(cur).append(num);
        if (sb.length() < len) {
            return sb.toString();
        } else {
            return str;
        }
    }
}
