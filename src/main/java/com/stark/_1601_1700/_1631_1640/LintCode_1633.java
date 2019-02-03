package com.stark._1601_1700._1631_1640;

import java.util.ArrayList;
import java.util.List;

public class LintCode_1633 {
    public String[] getAns(String target, String[] s) {
        // Write your code here
        List<String> res = new ArrayList<>();
        char[] chars = target.toCharArray();
        for(String str:s){
            if(contain(chars,str)){
                res.add(str);
            }
        }
        return res.toArray(new String[]{});
    }

    public boolean contain(char[] target,String input){
        int begin=0;
        for(char c:target){
            boolean flag = false;
            for(int i=begin;i<input.length();i++){
                if(input.charAt(i)==c){
                    begin=i+1;
                    flag=true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;
    }
}
