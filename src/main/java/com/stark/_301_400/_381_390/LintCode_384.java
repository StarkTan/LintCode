package com.stark._301_400._381_390;

/**
 * Created by Stark on 2017/9/19.
 * 给定一个字符串，请找出其中无重复字符的最长子字符串。
 */
public class LintCode_384 {
    public int lengthOfLongestSubstring(String s){
        if(s==null||s.isEmpty()){
            return 0;
        }
        int[] map = new int[128];
        char[] chars = s.toCharArray();
        map[chars[0]]++;
        int count=1;
        int res = 1;
        int begin = 0;
        int end = 0;
        while(end<chars.length-1){
            if(++map[chars[++end]]>1){
                res = Math.max(res,count++);
                while (map[chars[end]]>1){
                    map[chars[begin++]]--;
                    count--;
                }
            }else {
                count++;
            }
        }
        res = Math.max(res,count);
        return res;
    }

    public static void main(String[] args) {
        LintCode_384 lintCode_384 = new LintCode_384();
        int i = lintCode_384.lengthOfLongestSubstring("");
        System.out.println(i);
    }
}
