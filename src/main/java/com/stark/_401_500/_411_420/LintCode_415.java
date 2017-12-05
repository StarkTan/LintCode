package com.stark._401_500._411_420;

/**
 * Created by Stark on 2017/12/5.
 * 给定一个字符串，判断其是否为一个回文串。只包含字母和数字，忽略大小写。
 */
public class LintCode_415 {
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.isEmpty()) return true;
        s = s.toLowerCase();
        int begin = 0;
        int end = s.length() - 1;
        while (true) {
            while (begin < s.length() && !solve(s.charAt(begin))) begin++;
            while (end > 0 && !solve(s.charAt(end))) end--;
            if (begin >= end) break;
            if (s.charAt(begin) != s.charAt(end)) return false;
            begin++;
            end--;
        }
        return true;
    }

    private boolean solve(char c) {
        if (c >= 'a' && c <= 'z') return true;
        if (c >= '0' && c <= '9') return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_415().isPalindrome(" "));
    }
}
