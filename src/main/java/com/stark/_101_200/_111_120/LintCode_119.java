package com.stark._101_200._111_120;

/**
 * Created by Stark on 2017/10/9.
 * 给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。
 * 你总共三种操作方法：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class LintCode_119 {
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1.isEmpty()) {
            return word2.length();
        }
        if (word2.isEmpty()) {
            return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
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
                if (word2.charAt(j - 1) == word1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LintCode_119 test = new LintCode_119();
        int i = test.minDistance("adasdasf", "asfasdas");
        System.out.println(i);
    }
}
