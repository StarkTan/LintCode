package com.stark._101_200._191_200;

import java.util.*;

/**
 * Created by Stark on 2017/9/29.
 * 给出一个可能包含重复数字的排列，
 * 求这些数字的所有排列按字典序排序后该排列在其中的编号。编号从1开始。
 */
public class LintCode_198 {
    public long permutationIndexII(int[] A){
        long res =1;
        int len = A.length;
        int[] copyA = new int[len];
        for(int i=0;i<len;i++){
            copyA[i] = A[i];
        }
        Arrays.sort(copyA);
        //用于排序
        List<Integer> list = new ArrayList<>();
        //用于存储
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            Integer cur = copyA[i];
            if(!list.contains(cur)){
                list.add(copyA[i]);
            }
            if(map.containsKey(cur)){
                Integer integer = map.get(cur);
                map.put(cur,integer+1);
            }else {
                map.put(cur,1);
            }
        }
        int count =A.length;
        for(Integer cur :A){
            Integer integer = map.get(cur);
            int index = list.indexOf(cur);
            count--;

            for(int i=0;i<index;i++){
                Integer small = list.get(i);
                long down = getDown(map,small);
                res = res + getAdd(count)/down;
            }
            if(integer==1){
                map.remove(cur);
                list.remove(cur);
            }else {
                map.put(cur,integer-1);
            }

        }
        return res;
    }
    private long getAdd(int n){
        long res = 1L;
        if(n==0)return 0;
        while (n>0){
            res =res*n;
            n--;
        }
        return res;
    }

    private long getDown(Map<Integer, Integer> map, Integer small){
        long res = 1L;
        Integer integer = map.get(small);
        map.put(small,integer-1);
        Set<Integer> integers = map.keySet();
        for (Integer i:integers){
            Integer nums = map.get(i);
            if(nums ==0 )continue;
            res = res*getAdd(nums);
        }
        map.put(small,integer);
        return res;
    }
    public static void main(String[] args) {
        LintCode_198 test = new LintCode_198();
        long l = test.permutationIndexII(new int[]{4, 4, 2, 1});
        System.out.println(l);
    }
}
