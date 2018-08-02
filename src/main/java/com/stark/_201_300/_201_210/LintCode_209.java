package com.stark._201_300._201_210;

public class LintCode_209 {
    public class Solution {
        /**
         * @param str: str: the given string
         * @return: char: the first unique character in a given string
         */
        public char firstUniqChar(String str) {
            // Write your code here
            char res = '0';
            int len = str.length();
            a:
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                for (int j = 0; j < len; j++) {
                    if (i == j) continue;
                    if (c == str.charAt(j)) continue a;
                }
                res = c;
                break;
            }
            return res;
        }
    }
}
