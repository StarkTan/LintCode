package com.stark._101_200._191_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/9/29.
 * 给出一个不含重复数字的排列，求这些数字的所有排列按字典序排序后该排列的编号。其中，编号从1开始。
 */
public class LintCode_197 {
    public long permutationIndex(int[] A){
        int len = A.length;
        int[] copyA = new int[len];
        for(int i=0;i<len;i++){
            copyA[i] = A[i];
        }
        Arrays.sort(copyA);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(copyA[i]);
        }
        long count =1L;
        for (int cur : A) {
            int index = list.indexOf(cur);
            long cre =index*getAdd(list.size()-1);
            count = count+cre;
            list.remove(new Integer(cur));
        }
        return count;
    }

    private long getAdd(int n){
        long res = 1L;
        if(n==0)return 0;
        while (n>0){
            res =res*n;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_197 test = new LintCode_197();
        long l = test.permutationIndex(new int[]{5, 7, 3, 2});
        System.out.println(l);
    }
}
