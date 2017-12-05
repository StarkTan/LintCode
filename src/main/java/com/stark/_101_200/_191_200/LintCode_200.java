package com.stark._101_200._191_200;

/**
 * Created by Stark on 2017/12/5.
 * 给出一个字符串（假设长度最长为1000），求出它的最长回文子串，你可以假定只有一个满足条件的最长回文串。
 */
public class LintCode_200 {

    public String longestPalindrome(String s) {
        // write your code here
        char[] chars = s.toCharArray();
        int max = 1;
        int len = chars.length;
        int start = 0;
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            int p = i - 1;
            int q = i + 1;
            int count = 1;
            while (p >= 0 && q < len && chars[p] == chars[q]) {
                count += 2;
                p--;
                q++;
            }
            if (count > max) {
                max = count;
                start = p + 1;
                end = q - 1;
            }
            if (chars[i] == chars[i + 1]) {
                count = 0;
                p = i;
                q = i + 1;
                while (p >= 0 && q < len && chars[p] == chars[q]) {
                    count += 2;
                    p--;
                    q++;
                }
            }
            if (count > max) {
                max = count;
                start = p + 1;
                end = q - 1;
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LintCode_200 test = new LintCode_200();
        String s = test.longestPalindrome("ababababa");
        System.out.println(s);
    }
}
