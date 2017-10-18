package com.stark._101_200._131_140;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Stark on 2017/10/18.
 * 给定一个整数数组，找到一个和最接近于零的子数组。
 * 返回第一个和最有一个指数。你的代码应该返回满足要求的子数组的起始位置和结束位置
 */
public class LintCode_139 {

    //超时
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int cur = 0;
            for (int j = i; j < len; j++) {
                cur = cur + nums[j];
                if (Math.abs(0 - cur) < min) {
                    res[0] = i;
                    res[1] = j;
                    min = Math.abs(0 - cur);
                }
            }
        }
        return res;
    }


    class Pair{
        int sum;
        int index;
        public Pair(int s , int i){
            this.index = i;
            this.sum = s;
        }
    }
    public int[] subarraySumClosest_V2(int[] nums) {
        // write your code here
        int[] result = new int[]{0 , 0};
        if(nums == null || nums.length == 0 || nums.length == 1){
            return result;
        }

        int len = nums.length;
        Pair[] record = new Pair[len + 1];
        record[0] = new Pair(0 , 0);
        int prev = 0;
        for(int i = 1; i< len + 1;i++){
            prev += nums[i - 1];
            record[i] = new Pair(prev , i);
        }

        Arrays.sort(record , new Comparator<Pair>(){
            public int compare(Pair a , Pair b){
                return a.sum - b.sum;
            }
        });

        int min = Integer.MAX_VALUE;
        for(int i = 1;i<len + 1;i++){
            if(min > record[i].sum - record[i - 1].sum){
                min = record[i].sum - record[i - 1].sum;
                result[0] = Math.min(record[i].index , record[i - 1].index);
                result[1] = Math.max(record[i].index , record[i - 1].index) - 1;
            }
        }

        return result;
    }

}
