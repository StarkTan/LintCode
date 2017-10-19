package com.stark._601_700._671_680;

/**
 * Created by Stark on 2017/10/20.
 * 给一个字符串 S, 你可以通过在前面添加字符将其转换为回文串.找到并返回用这种方式转换的最短回文串.
 */
public class LintCode_678 {
    public String convertPalindrome(String str) {
        // Write your code here
        if (str.isEmpty()) {
            return str;
        }
        char[] chars = str.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        for (; end >= 0; end--) {
            if (solve(chars, begin, end)) break;
        }
        StringBuilder res = new StringBuilder();
        for (int i = chars.length - 1; i > end; i--) {
            res.append(chars[i]);
        }
        res.append(str);
        return res.toString();

    }

    private boolean solve(char[] chars, int begin, int end) {
        while (begin < end) {
            if (chars[begin] != chars[end]) {
                return false;
            } else {
                begin++;
                end--;
            }
        }
        return true;
    }
}
