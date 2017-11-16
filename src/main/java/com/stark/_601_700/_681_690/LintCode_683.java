package com.stark._601_700._681_690;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stark on 2017/10/30.
 * 给出一个单词表和一条去掉所有空格的句子，根据给出的单词表添加空格,
 * 返回可以构成的句子的数量, 保证构成的句子中所有的单词都可以在单词表中找到.
 */
public class LintCode_683 {
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        int len = s.length();
        //i代表开始，j代表结束
        int[][] dp = new int[len][len];
        boolean[][] visit = new boolean[len][len];
        int begin = 0;
        int end = len - 1;
        solve(s, dict, begin, end, dp, visit);
        return dp[begin][end];
    }

    private void solve(String s, Set<String> dict, int begin, int end, int[][] dp, boolean[][] visit) {
        if (visit[begin][end]) return;
        for (int i = begin; i <= end; i++) {
            if (i == end) {
                dp[begin][end] += dict.contains(s.substring(begin, end + 1)) ? 1 : 0;
                continue;
            }
            if (dict.contains(s.substring(begin, i + 1))) {
                solve(s, dict, i + 1, end, dp, visit);
                dp[begin][end] += dp[i + 1][end];
            }
        }
        int i = dp[begin][end];
        visit[begin][end] = true;
    }


    public static void main(String[] args) {

        LintCode_683 test = new LintCode_683();
        String s = "CatMat";
        Set<String> dict = new HashSet<>();
        dict.add("Cat");
        dict.add("Mat");
        dict.add("Ca");
        dict.add("tM");
        dict.add("at");
        dict.add("C");
        dict.add("Dog");
        dict.add("og");
        dict.add("Do");
        int i = test.wordBreak3(s, dict);
        System.out.println(i);
    }
}
