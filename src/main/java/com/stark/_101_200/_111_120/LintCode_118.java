package com.stark._101_200._111_120;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stark on 2017/10/3.
 * 给出字符串S和字符串T，计算S的不同的子序列中T出现的个数。
 * 子序列字符串是原始字符串通过删除一些(或零个)产生的一个新的字符串，
 * 并且对剩下的字符的相对位置没有影响。(比如，“ACE”是“ABCDE”的子序列字符串,而“AEC”不是)。
 */
public class LintCode_118 {
    //递归超时
    public int numDistinct(String S, String T) {
        // write your code here
        if(T.isEmpty()) return 1;
        char[] chars = S.toCharArray();
        char[] chars1 = T.toCharArray();
        //把不需要的数据剔除
        Set<Character> set = new HashSet<>();
        for(Character c : chars1){
            set.add(c);
        }
        int d = 0;
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            if(!set.contains(c)){
                chars[i] ='_';
                d++;
            }
        }
        char[] chars2 = new char[chars.length-d];
        int index =0;
        for (char c : chars) {
            if (set.contains(c)) {
                chars2[index++] = c;
            }
        }
        int begin = 0;
        int end = chars2.length - 1;
        int left = chars1.length;
        for (int i = 0; i < chars2.length; i++) {
            if (chars2[i] == chars1[0]) {
                begin = i;
                break;
            }
        }
        for (int i = chars2.length - 1; i >= 0; i--) {
            if (chars2[i] == chars1[chars1.length - 1]) {
                end = i;
                break;
            }
        }
        return solve(chars2,chars1,begin,end,left);
    }

    private Integer solve(char[] chars, char[] chart, int begin, int end, int left) {
        Integer res = 0;
        if(end-begin+1<left) return res;
        for(int i=begin;i<=end;i++){
            if(chars[i]==chart[chart.length-left]){
                if(left==1){
                    res++;
                }else {
                    res += solve(chars,chart,i+1,end,left-1);
                }
            }
        }
        return res;
    }
    //动态规划
    public int numDistinct_V2(String S, String T){
        char[] charS = S.toCharArray();
        char[] charT = T.toCharArray();

        int[] dp = new int[T.length()+1];
        dp[0]=1;
        for (int i=1;i<=charS.length;i++){
            for(int j=charT.length;j>0;j--){
                dp[j] += charS[i]==charT[j]?dp[j-1]:0;
            }
        }
        return dp[T.length()];
    }


}
