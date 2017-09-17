package com.stark._301_400._381_390;

import java.util.Arrays;

/**
 * Created by Stark on 2017/9/17.
 * 给定两个整数数组（第一个是数组 A，第二个是数组 B），
 * 在数组 A 中取 A[i]，数组 B 中取 B[j]，A[i] 和 B[j]两者的差越小越好(|A[i] - B[j]|)。返回最小差。
 */
public class LintCode_387 {
    public int smallestDifference(int[] A, int[] B) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(A);
        Arrays.sort(B);
        int a = 0;
        int b = 0;
        while(a<A.length&&b<B.length){
            min = Math.min(min,Math.abs(A[a]-B[b]));
            if(A[a]<B[b]) a++;
            else b++;
        }
        /*for(int i = 0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int cur = Math.abs((A[i]-B[j]));
                if(cur<min) min = cur;
            }
        }*/
        return min;
    }
}
