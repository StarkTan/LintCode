package com.stark._1_100._51_60;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stark on 2017/9/15.
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 1 到 n，不是以 0 开头。
 * 默认有解
 */
public class LintCode_56 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            if(map.containsKey(num)){
                res[0]=map.get(num)+1;
                res[1]=i+1;
                break;
            }else {
                int div = target-num;
                if(!map.containsKey(div)){
                    map.put(div,i);
                }
            }
        }
        return res;
    }
}
