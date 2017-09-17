package com.stark._301_400._381_390;

/**
 * Created by Stark on 2017/9/17.
 * 给定一个整数数组，在该数组中，寻找三个数，
 * 分别代表三角形三条边的长度，问，可以寻找到多少组这样的三个数来组成三角形？
 */
public class LintCode_382 {
    public int triangleCount(int S[]) {
        int result = 0;
        int len = S.length;
        for(int i=0;i<len-2;i++)
        {
            for(int j=i+1;j<len-1;j++){
                for(int k=j+1;k<len;k++)
                {
                    int add  = S[i]+S[j];
                    int del = Math.max(S[i]-S[j],S[j]-S[i]);
                    if(del<S[k]&&S[k]<add) result++;
                }
            }
        }
        return result;
    }
}
