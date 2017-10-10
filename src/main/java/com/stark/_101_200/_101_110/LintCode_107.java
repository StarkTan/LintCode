package com.stark._101_200._101_110;

import java.util.Set;

/**
 * Created by Stark on 2017/10/9.
 * 给出一个字符串s和一个词典，判断字符串s是否可以被空格切分成一个或多个出现在字典中的单词。
 */
public class LintCode_107 {
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        /*动态规划 空间不足
        if (s.isEmpty()) {
            return true;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int begin = j;
                int end = j + i;
                String sub = s.substring(begin, end + 1);
                if (dict.contains(sub)) {
                    dp[begin][end] = true;
                } else {
                    for (int k = begin; k < end; k++) {
                        if (dp[begin][k] && dp[k + 1][end]) {
                            dp[begin][end] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][len - 1];*/
        //动态规划 一次遍历
        if ((s == null || s.length() == 0) && (dict == null || dict.size() == 0)) {
            return true;
        }
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;//初始值
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i])
                continue;
            for (String t : dict) {
                int len = t.length();
                int end = i + len;
                if (end > s.length())
                    continue;
                if (s.substring(i, end).equals(t)) {
                    dp[end] = true;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        System.out.println("01234".substring(0, 0));
    }
}
