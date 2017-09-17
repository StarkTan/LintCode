package com.stark._601_700._641_650;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Stark on 2017/9/17.
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and
 * p will not be larger than 40,000.
 */
public class LintCode_647 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<Integer>();
        if(s == null || s.length() < p.length()){
            return indices;
        }
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        for(int i = 0; i < p.length(); i++){
            pMap[p.charAt(i) - 'a']++;
        }
        Queue<Character> queue = new LinkedList<Character>();
        int index = 0;
        while(index < s.length()){
            queue.add(s.charAt(index));
            sMap[s.charAt(index) - 'a']++;
            if(queue.size() == p.length()){
                if(isAnagrams(sMap, pMap)){
                    indices.add(index - p.length() + 1);
                }
                sMap[queue.poll() - 'a']--;
            }
            index++;
        }
        return indices;
    }
    private boolean isAnagrams(int[] sMap, int[] pMap){
        for(int i = 0; i < sMap.length; i++){
            if(sMap[i] != pMap[i]){
                return false;
            }
        }
        return true;
    }
}
