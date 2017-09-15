package com.stark._1_100._51_60;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 单词的构成：无空格字母构成一个单词
 * 输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
 * 如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
 */
public class LintCode_53 {
    public String reverseWords(String s) {
        if(!s.trim().contains(" ")){
            return s.trim();
        }
        String[] split = s.split(" ");
        StringBuilder sb  = new StringBuilder("");
        for(int i=split.length-1;i>0;i--){
            if(!split[i].isEmpty()){
                sb.append(split[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String[] split = "sdasd     sdasd  ".split(" ");
        System.out.println(split);
    }
}
