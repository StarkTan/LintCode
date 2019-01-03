package com.stark._601_700._671_680;

public class LintCode_676 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int mod = (int) (1e9 + 7);
        long[] dp = new long[s.length() + 1];

        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);

            if (c == '*') {
                dp[i] += 9 * dp[i - 1];
                dp[i] = dp[i] % mod;

                if (i > 1) {
                    if (s.charAt(i - 2) == '1') dp[i] += 9 * dp[i - 2];
                    if (s.charAt(i - 2) == '2') dp[i] += 6 * dp[i - 2];
                    if (s.charAt(i - 2) == '*') dp[i] += 15 * dp[i - 2];
                    //dp[i] = dp[i] % mod;
                }
            } else if (c == '0') {
                if (i == 0) return 0;
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') dp[i] += dp[i - 2];
                if (s.charAt(i - 2) == '*') dp[i] += 2 * dp[i - 2];
                //dp[i] = dp[i] % mod;
            } else {
                dp[i] += dp[i - 1];
                dp[i] = dp[i] % mod;

                if (i > 1)
                    if (s.charAt(i - 2) == '*') {
                        if (c >= '0' && c <= '9') dp[i] += dp[i - 2];
                        dp[i] = dp[i] % mod;
                        if (c >= '0' && c <= '6') dp[i] += dp[i - 2];
                        dp[i] = dp[i] % mod;
                    } else {
                        int v = Integer.parseInt(s.substring(i - 2, i));
                        if (v >= 10 && v <= 26) dp[i] += dp[i - 2];
                    }
            }
            dp[i] = dp[i] % mod;
        }

        return (int) dp[s.length()];
    }
}
