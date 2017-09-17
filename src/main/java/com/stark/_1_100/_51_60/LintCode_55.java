package com.stark._1_100._51_60;

/**
 * Created by Stark on 2017/9/15.
 */
public class LintCode_55 {
    public boolean compareStrings(String A, String B) {
        // write your code here
        int[] map = new int[95];
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        for(char c:charsA){
            map[c]++;
        }
        for(char c:charsB){
            if(--map[c]<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('Z'-0);
    }
}
