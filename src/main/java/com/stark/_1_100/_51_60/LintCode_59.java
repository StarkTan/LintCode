package com.stark._1_100._51_60;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * Created by Stark on 2017/9/15.
 * 给一个包含 n 个整数的数组 S, 找到和与给定整数 target 最接近的三元组，返回这三个数的和。
 */
public class LintCode_59 {
    public int threeSumClosest(int[] numbers, int target) {
        Arrays.sort(numbers);
        int len =numbers.length;
        int res = 0;
        int close = Integer.MAX_VALUE;
        for(int i=0;i<len-2;i++){
            int tie = numbers[i];
            int begin = i+1;
            int end = len-1;
            while (begin<end){
                int cur = tie+numbers[begin]+numbers[end];
                int curClose = Math.abs(cur-target);
                if(curClose<close){
                    close = curClose;
                    res = cur;
                }
                if(cur>target){
                    end--;
                }else {
                    begin++;
                }
            }
        }
        return res;
    }

}
