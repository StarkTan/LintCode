package com.stark._601_700._631_640;

/**
 * Created by Stark on 2017/10/9.
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class LintCode_640 {
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        if (s == null || t == null) {
            return false;
        }
        int lens = s.length();
        int lent = t.length();
        if (Math.abs(lens - lent) > 1) {
            return false;
        } else if (lens == lent) { //长度相等
            int edit = 0;
            for (int i = 0; i < lens; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    edit++;
                }
            }
            if (edit != 1) {
                return false;
            } else {
                return true;
            }
        } else if (Math.abs(lens - lent) == 1) {
            String minString = lens < lent ? s : t;
            String maxString = lens < lent ? s : t;
            if (minString.length() == 0) {
                return true;
            }
            int p = 0;
            for (int i = 0; i < minString.length(); i++) {
                if (minString.charAt(i) != minString.charAt(i + p)) {
                    if (p > 1) {
                        return false;
                    } else {
                        p++;
                        i--;
                    }
                }
            }
            if(p==0){
                return true;
            }
            return true;
        }
        return false;
        /*提交超时
        if (s == null || t == null) {
            return false;
        }
        int m = s.length();
        int n = t.length();
        //表示前ij需要变化的数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (t.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n] == 1;*/


    }

    public static void main(String[] args) {
        LintCode_640 test = new LintCode_640();
        boolean oneEditDistance = test.isOneEditDistance("abc", "abcd");
        System.out.println(oneEditDistance);
    }
}
