package com.stark._501_600._581_590;

import com.stark._601_700._681_690.LintCode_683;

import java.util.*;

/**
 * Created by Stark on 2017/11/2.
 * 给一字串s和单词的字典dict,在字串中增加空格来构建一个句子，并且所有单词都来自字典。
 * 返回所有有可能的句子。
 */
public class LintCode_582 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        int len = s.length();
        //i代表开始，j代表结束
        Map<String, List<String>> dp = new HashMap<>();

        boolean[][] visit = new boolean[len][len];
        int begin = 0;
        int end = len - 1;
        solve(s, wordDict, begin, end, dp, visit);
        return dp.get(begin + "," + end);
    }

    private void solve(String s, Set<String> wordDict, int begin, int end, Map<String, List<String>> dp, boolean[][] visit) {
        if (visit[begin][end]) return;
        List<String> list = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            String sub = s.substring(begin, i + 1);
            if (i == end && wordDict.contains(sub)) {
                list.add(sub);
                continue;
            }

            if (wordDict.contains(sub)) {
                solve(s, wordDict, i + 1, end, dp, visit);
                List<String> list1 = dp.get((i + 1) + "," + end);
                for (String s1 : list1) {
                    list.add(sub + " " + s1);
                }
            }
        }
        dp.put(begin + "," + end, list);
        visit[begin][end] = true;
    }

    public static void main(String[] args) {

        LintCode_582 test = new LintCode_582();
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
        List<String> list = test.wordBreak(s, dict);
        System.out.println(list);
    }
}
