package com.stark._101_200._191_200;

/**
 * Created by Stark on 2017/12/6.
 * 通配符
 */
public class LintCode_192 {

    public boolean isMatch(String s, String p) {
        // write your code here
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
            else dp[0][j] = false;
        }
        for (int i = 1; i <= m; i++) {
            char sc = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char ps = p.charAt(j - 1);
                if (ps == sc || ps == '?') dp[i][j] = dp[i - 1][j - 1];
                if (ps == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
