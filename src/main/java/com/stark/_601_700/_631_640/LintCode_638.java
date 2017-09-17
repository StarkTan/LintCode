package com.stark._601_700._631_640;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stark on 2017/9/17.
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 */
public class LintCode_638 {

    public boolean isIsomorphic(String s, String t) {
        if(null ==s||null==t)return false;
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int len = s.length();
        for(int i=0;i<len;i++){
            Character a = chars1[i];
            Character b = chars2[i];
            if(map1.containsKey(a)&&map1.get(a)!=b) return false;
            if(!map1.containsKey(a)) map1.put(a,b);

            if(map2.containsKey(b)&&map2.get(b)!=a) return false;
            if(!map2.containsKey(b)) map2.put(b,a);
        }
        return true;
    }
}
