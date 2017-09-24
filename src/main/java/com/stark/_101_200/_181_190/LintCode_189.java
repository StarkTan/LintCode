package com.stark._101_200._181_190;

/**
 * Created by Stark on 2017/9/20.
 * 给出一个无序的正数数组，找出其中没有出现的最小正整数。
 */
public class LintCode_189 {
    public int firstMissingPositive(int[] A) {
        // write your code here
        int len = A.length;
        int[] map = new int[len];
        for (int a : A) {
            if (a > 0&&a<=len) {
                map[a - 1] = 1;
            }
        }
        for(int i=0;i<len;i++){
            if(map[i]==0){
                return i+1;
            }
        }
        return len+1;
    }
}
