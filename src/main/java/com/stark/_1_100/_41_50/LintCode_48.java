package com.stark._1_100._41_50;

import java.util.*;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k。
 * 注意事项
 * 数组中只有唯一的主元素
 */
public class LintCode_48 {
    public int majorityNumber(List<Integer> nums, int k) {
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
            if(next.getValue()>size/k){
                return next.getKey();
            }
        }
        return 0;
    }
}
