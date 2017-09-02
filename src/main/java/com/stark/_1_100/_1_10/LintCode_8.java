package com.stark._1_100._1_10;

/**
 * Created by Stark on 2017/9/2.
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 */
public class LintCode_8 {
    //时间O(2n),空间O(n)
    public void rotateString_V1(char[] str, int offset) {
        int len =str.length;
        if(len==0) return;
        offset = offset%len;
        char[] copy = new char[len];
        int i=0;
        for(int j=len-offset;j<len;j++){
            copy[i] = str[j];
            i++;
        }
        for(int j=0;j<len-offset;j++){
            copy[i] = str[j];
            i++;
        }
        for(int k=0;k<len;k++){
            str[k] = copy[k];
        }

    }
    //时间O(n*k),空间O(1)
    public void rotateString_V2(char[] str, int offset) {
        int len =str.length;
        if(len==0) return;
        offset = offset%len;
        for(int i=0;i<offset;i++){
            char temp = str[len-1];
            for(int j=len-1;j>0;j--){
                str[j] = str[j-1];
            }
            str[0] = temp;
        }
    }
}
