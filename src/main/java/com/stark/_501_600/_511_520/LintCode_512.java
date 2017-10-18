package com.stark._501_600._511_520;

/**
 * Created by Stark on 2017/10/18.
 * 有一个消息包含A-Z通过以下规则编码
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 现在给你一个加密过后的消息，问有几种解码的方式
 */
public class LintCode_512 {
    public int numDecodings(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.startsWith("0")) {
            return 0;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {

            int solve = solve(chars[i - 1], chars[i]);
            if (solve == 3) {
                return 0;
            }
            if (solve == 2) {
                dp[i + 1] = dp[i - 1];
                continue;
            }
            dp[i + 1] = dp[i] + dp[i - 1] * solve;
        }
        return dp[len];
    }

    private int solve(char c1, char c2) {
        int i1 = c1 - '0';
        int i2 = c2 - '0';
        if (i1 == 0 && i2 == 0) {
            return 3;
        }
        if (i2 == 0 && i1 > 2) {
            return 3;
        }

        if (i1 == 0) {
            return 0;
        }
        if (i2 == 0) {
            return 2;
        }
        return i1 * 10 + i2 > 26 ? 0 : 1;
    }
}
