package com.stark._1_100._21_30;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/9/7.
 *
 */
public class LintCode_29 {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        char[] char3 = s3.toCharArray();

        //初始条件
        List<int[]> ini = new ArrayList<int[]>();
        ini.add(new int[]{-1,-1});

        for(int i = 0;i<char3.length;i++){
            char c = char3[i];
            List<int[]> count = new ArrayList<int[]>();
            for(int[] ints:ini){
                int a = ints[0];
                int b = ints[1];
                if(a<char1.length-1&&char1[a+1]==c){
                    count.add(new int[]{a+1,b});
                }
                if(b<char2.length-1&&char2[b+1]==c){
                    count.add(new int[]{a,b+1});
                }
            }
            ini = count;
        }
        return !ini.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_29().isInterleave("aabcc","dbbca","aadbbbaccc"));
    }
}
