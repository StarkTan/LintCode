package com.stark._1_100._41_50;

import java.util.*;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
 * 唯一
 */
public class LintCode_47 {
    public int majorityNumber(List<Integer> nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int size = nums.size();
        for(Integer integer : nums){
            if(map.containsKey(integer)){
                Integer time = map.get(integer)+1;
                map.put(integer,time);
            }else {
                map.put(integer,1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue()>size/3){
                return next.getKey();
            }
        }
        return 0;
    }
}
