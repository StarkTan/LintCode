package com.stark._601_700._671_680;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/9/28.
 * The words are same rotate words if rotate the word to the right by loop, and get another.
 * Count how many different rotate word sets in dictionary.
 * 提交溢出报错
 */
public class LintCode_671 {
    /*溢出
    public int countRotateWords(List<String> words) {
        // Write your code here
        int count = words.size();
        Object[] objects = words.toArray();
        boolean[] bad = new boolean[count];
        for(int i=0;i<count;i++){
            if(bad[i])continue;
            for(int j=i+1;j<count;j++){
                if(bad[j])continue;
                if(match(objects[i].toString(),objects[j].toString())){
                    bad[j] = true;
                }
            }
        }
        for(int i=0;i<bad.length;i++){
            if(bad[i])count--;
        }
        return count;
    }
*/
    private  boolean match(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
//        char[] chars1 = s1.toCharArray();
//        char[] chars2 = s2.toCharArray();
//        char begin = chars1[0];
//        int shift = 0;
//        for(int i=0;i<chars1.length;i++){
//            if(chars2[i]==begin){
//                shift = i;
//                boolean res = true;
//                for(int j=0;j<chars1.length;j++){
//                    if(chars1[j]!=chars2[(j+shift)%chars1.length]){
//                        res = false;
//                    }
//                }
//                if(res) return true;
//            }
//        }
//        return false;
        return s1.concat(s1).contains(s2);
    }
    public int countRotateWords(List<String> words){
        int count = 0;
        while (!words.isEmpty()){
            count++;
            String s = words.get(0);
            for(int i=0;i<words.size();i++){
                if(match(s,words.get(i))){
                    words.remove(i);
                    i--;
                }
            }
        }
        return count;
    }
}
