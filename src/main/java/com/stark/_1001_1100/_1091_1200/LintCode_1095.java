package com.stark._1001_1100._1091_1200;

public class LintCode_1095 {
    public int maximumSwap(int num) {
        // Write your code here
        char[] chars = (num+"").toCharArray();
        int maxIndex = -1;
        int maxChar = '0';

        for(int i=0;i<chars.length;i++){
            char cur = chars[i];
            if(maxChar <= cur){
                for(int j=0;j<i;j++){
                    if(cur>chars[j]){
                        maxChar = cur;
                        maxIndex = i;
                        break;
                    }
                }

            }
        }
        for(int i=0;i<maxIndex;i++) {
            char cur = chars[i];
            if(maxChar > cur){
                chars[i] = (char)maxChar;
                chars[maxIndex] = cur;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_1095().maximumSwap(1234));
    }
}
