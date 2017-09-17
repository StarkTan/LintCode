package com.stark._401_500._421_430;

/**
 * Created by Stark on 2017/9/17.
 * 给定一个字符串， 包含大小写字母、空格' '，请返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 */
public class LintCode_422 {
    public int lengthOfLastWord(String s) {
        // write your code here
        if(s==null) return 0;
        s = s.trim();
        if(s.isEmpty()) return 0;
        if(s.contains(" ")){
            String[] split = s.split(" ");
            return split[split.length-1].length();
        }else {
            return s.length();
        }
    }
}
