package com.stark._1_100._41_50;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个整数数组A。
 * 定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]， 计算B的时候请不要使用除法。
 */
public class LintCode_50 {
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> res = new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            Long re = 1L;
            for(int j=0;j<nums.size();j++){
                if(i==j){
                    continue;
                }else {
                    re = re*nums.get(j);
                }
            }
            res.add(re);
        }
        return res;
    }
}
