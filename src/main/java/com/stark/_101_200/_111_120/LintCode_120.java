package com.stark._101_200._111_120;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Stark on 2017/9/17.
 * 给出两个单词（start和end）和一个字典，找到从start到end的最短转换序列
 * 每次只能改变一个字母。
 * 变换过程中的中间单词必须在字典中出现。
 * 注意事项
 * 如果没有转换序列则返回0。
 * 所有单词具有相同的长度。
 * 所有单词都只包含小写字母。
 */
public class LintCode_120 {
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end)) {
            return 1;
        }
        if (match(start, end)) {
            return 2;
        }
        Set<String> list = new HashSet<>();
        list.add(start);
        int step = 2;
        while (!list.isEmpty()) {
            Set<String> newlist = new HashSet<>();
            for (String cur : list) {
                for (String com : dict) {
                    if (match(com, cur)) {
                        if (match(com, end)) {
                            return step + 1;
                        } else {
                            newlist.add(com);
                        }
                    }
                }
            }

            for (String s : newlist) {
                dict.remove(s);
            }
            list = newlist;
            step++;
        }
        return 0;
    }

    private boolean match(String start, String end) {
        int len = start.length();
        boolean one = false;
        for (int i = 0; i < len; i++) {
            if (start.charAt(i) != end.charAt(i)) {
                if (one) {
                    return false;
                } else {
                    one = true;
                }
            }
        }
        return one;
    }

    public static void main(String[] args) {
        LintCode_120 lintCode_120 = new LintCode_120();
        Set<String> dict = new HashSet<>();
        String[] strings = new String[]{"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        for (String s : strings) {
            dict.add(s);
        }
        int ladders = lintCode_120.ladderLength("qa", "sq", dict);
        System.out.println(ladders);
    }

}
