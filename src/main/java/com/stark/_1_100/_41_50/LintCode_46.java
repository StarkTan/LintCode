package com.stark._1_100._41_50;

import java.util.List;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 * 主元素存在
 */
public class LintCode_46 {
    public int majorityNumber(List<Integer> nums) {
        int count = 1;
        int cur = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == cur) {
                count++;
                if(count>nums.size()/2){
                    return cur;
                }
            } else {
                count--;
                if (count < 0) {
                    cur = nums.get(i);
                    count = 1;
                }
            }
        }
        return cur;
    }
}
