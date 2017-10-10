package com.stark._101_200._151_160;

import java.util.Arrays;

/**
 * Created by Stark on 2017/10/9.
 * 写出一个函数 anagram(s, t) 判断两个字符串是否可以通过改变字母的顺序变成一样的字符串。
 */
public class LintCode_158 {
    public boolean anagram(String s, String t) {
        // write your code here
        if(null==s||null==t) {
            return false;
        }
        if(s.length()!=t.length()){
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for(int i=0;i<chars1.length;i++){
            if(chars1[i]!=chars2[i]){
                return false;
            }
        }
        return true;
    }
}
