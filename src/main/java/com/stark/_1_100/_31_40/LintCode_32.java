package com.stark._1_100._31_40;

/**
 * Created by Stark on 2017/9/8.
 * 给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的子串。
 * 如果在source中没有这样的子串，返回""，如果有多个这样的子串，返回起始位置最小的子串。
 */
public class LintCode_32 {
    public String minWindow(String source, String target) {
        int count = target.length();
        char[] chars2 = target.toCharArray();
        char[] chars1 = source.toCharArray();
        int[] tMap = new int[128];
        for (char c : chars2) {
            tMap[c]++;
        }
        int begin = 0;
        int end = 0;
        int start = 0;
        int width = chars1.length+1;
        while (end < chars1.length) {
            if (tMap[chars1[end++]]-- > 0) count--;
            while (count == 0) {
                if (end - begin < width) {
                    width = end - begin;
                    start = begin;
                }
                if (tMap[chars1[begin++]]++ == 0) count++;
            }
        }
        if(width>=chars1.length+1) return "";
        return source.substring(start,start+width);
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_32().minWindow("1312A23141BC","AB"));
    }
}
