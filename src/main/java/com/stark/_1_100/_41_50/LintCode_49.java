package com.stark._1_100._41_50;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个只包含字母的字符串，按照先小写字母后大写字母的顺序进行排序。
 * 注意事项
 * 小写字母或者大写字母他们之间不一定要保持在原始字符串中的相对位置。
 */
public class LintCode_49 {
    public void sortLetters(char[] chars) {
        //write your code here
        int begin = 0;
        int end =chars.length-1;
        while(end>begin){
            if(chars[begin]-'a'<0){
                char temp = chars[end];
                chars[end] = chars[begin];
                chars[begin] = temp;
                end--;
            }else {
                begin++;
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = "AaASdsadA".toCharArray();
        new LintCode_49().sortLetters(chars);
        System.out.println(chars);
    }
}
