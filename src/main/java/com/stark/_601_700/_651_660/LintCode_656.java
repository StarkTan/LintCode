package com.stark._601_700._651_660;

/**
 * Created by Stark on 2017/9/29.
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2
 */
public class LintCode_656 {
    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        int[] add = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            int one = chars1[len1 - 1 - i] - '0';
            for (int j = 0; j < len2; j++) {
                int two = chars2[len2 - 1 - j] - '0';
                add[i + j] += one * two;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len1 + len2; i++) {
            if (add[i] > 10) {
                add[i + 1] += add[i] / 10;
            }
            add[i] = add[i]%10;
        }
        for (int i = len1+len2-1; i >=0; i--) {
            if(sb.length()==0&&add[i]==0){
            }else {
                sb.append(add[i]);
            }
        }
        if(sb.length()==0)return "0";
        return sb.toString();
    }
    public static void main(String[] args) {
        LintCode_656 test = new LintCode_656();
        String multiply = test.multiply("123", "45");
        System.out.println(multiply);
    }
}
