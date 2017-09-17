package com.stark._601_700._641_650;

/**
 * Created by Stark on 2017/9/17.
 * Given a string,
 * find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 */
public class LintCode_646 {
    public int firstUniqChar(String s) {
        if(null==s) return -1;
        for(int i=0;i<s.length();i++ ){
            char c = s.charAt(i);
            if(s.indexOf(c)==s.lastIndexOf(c)) return i;
        }
        return -1;
    }
}
