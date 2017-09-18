package com.stark._1_100._71_80;

/**
 * Created by Stark on 2017/9/18.
 * 最长公共前缀
 */
public class LintCode_78 {
    public String longestCommonPrefix(String[] strs) {

        // write your code here
        if(strs.length==0){
            return "";
        }
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            prefix = getPrefix(prefix,strs[i]);
            if(prefix.isEmpty()){
                return "";
            }
        }
        return prefix;
    }

    private String getPrefix(String prefix, String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<prefix.length()&&i<str.length();i++){
            if(prefix.charAt(i)==str.charAt(i)){
                sb.append(prefix.charAt(i));
            }else {
                break;
            }
        }
        return sb.toString();
    }
}
