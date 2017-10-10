package com.stark._101_200._101_110;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/10.
 * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
 */
public class LintCode_108 {
    public int minCut(String s) {
        if(s == null||s.length() == 0)
            return 0;
        int[] dp=new int[s.length()];
        char[] chars = s.toCharArray();
        //dp[i]存放(0,i)即以i的字符结束的子串的最小切割数，则所求为dp[s.length()-1];
        dp[0]=0;//一个字符，不需要切割
        for(int i=1;i<s.length();i++)
        {
            //dp[i]赋初值
            dp[i]=is_palindrome(chars,0,i)?0:i+1;
            //  1=<j<=i的子串回文判定
            for(int j=i;j>=1;j--)
            {
                if(is_palindrome(chars,j,i))
                {
                    dp[i]=Math.min(dp[i],dp[j-1]+1);
                }
            }
        }
        return dp[s.length()-1];
    }
    private boolean is_palindrome(char[] chars, int begin, int end) {
        while (begin < end) {
            if (chars[begin] != chars[end]) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
    //判断回文串例程
    /*内存溢出
    public boolean is_palindrome(String s)
    {
        int begin=0;
        int end=s.length()-1;
        while(begin<end)
        {
            if(s.charAt(begin)!=s.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }*/



    public static void main(String[] args) {
        LintCode_108 test = new LintCode_108();
        int i = test.minCut("aadaa");
        System.out.println(i);
    }

}
