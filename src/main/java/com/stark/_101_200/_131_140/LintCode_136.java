package com.stark._101_200._131_140;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/10.
 * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
 * 返回s所有可能的回文串分割方案。
 */
public class LintCode_136 {
    public List<List<String>> partition(String s) {
        // write your code here
        if (s == null) {
            return new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        int len = s.length();
        return solve(chars, 0, len - 1, s);
    }

    private List<List<String>> solve(char[] chars, int begin, int end, String s) {
        List<List<String>> lists = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            if (ifMatch(chars, begin, i)) {
                String cur = s.substring(begin, i + 1);
                if (i == end) {
                    List<String> list = new ArrayList<>();
                    list.add(cur);
                    lists.add(list);
                } else {
                    List<List<String>> solve = solve(chars, i + 1, end, s);
                    for (List<String> list : solve) {
                        list.add(0, cur);
                    }
                    lists.addAll(solve);
                }
            }
        }
        return lists;
    }

    //判断是否是回文串:
    private boolean ifMatch(char[] chars, int begin, int end) {
        while (begin < end) {
            if (chars[begin] != chars[end]) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
    /*
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 1 || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = s.length();
        List<List<String>> lists = solve(chars, 0, len - 1);
        int res = len;
        for (List list : lists) {
            res = Math.min(res, list.size());
        }
        return res-1;
    }


    private List<List<String>> solve(char[] chars, int begin, int end) {
        List<List<String>> lists = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            if (ifMatch(chars, begin, i)) {
                String cur = begin + "," + i;
                if(i==end){
                    List<String> list = new ArrayList<>();
                    list.add(cur);
                    lists.add(list);
                }else {
                    List<List<String>> solve = solve(chars, i + 1, end);
                    for(List<String> list:solve){
                        list.add(0,cur);
                    }
                    lists.addAll(solve);
                }
            }
        }
        return lists;
    }

    //判断是否是回文串:
    private boolean ifMatch(char[] chars, int begin, int end) {
        while (begin < end) {
            if (chars[begin] != chars[end]) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
     */
}
