package com.stark._601_700._621_630;

import java.util.Arrays;

/**
 * Created by Stark on 2017/9/17.
 * 给出一个包含大小写字母的字符串。求出由这些字母构成的最长的回文串的长度是多少。
 * 数据是大小写敏感的，也就是说，"Aa" 并不会被认为是一个回文串。
 */
public class LintCode_627 {
    public int longestPalindrome(String s) {
        if(null==s)return 0;
        // Write your code here
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int i= 0;
        int res =0;
        while(i<chars.length-1){
            if(chars[i]==chars[i+1]){
                res = res+2;
                i=i+2;
            }else{
                i=i+1;
            }
        }
        if(chars.length>res) res++;
        return res;
    }
}
