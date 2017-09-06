package com.stark._1_100._11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/9/6.
 * \给定一个可能具有重复数字的列表，返回其所有可能的子集
 */
public class LintCode_18 {
    //非递归
    public List<List<Integer>> subsetsWithDup_V1(int[] nums) {

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        //对数组进行排序
        Arrays.sort(nums);
        //初始化空集和下阶段修改值
        List<Integer> empty = new ArrayList<Integer>();
        lists.add(empty);
        if (nums.length == 0) {
            return lists;
        }
        List<List<Integer>> map = new ArrayList<List<Integer>>();
        //将第一个数做特殊处理
        List<Integer> first = new ArrayList<Integer>();
        first.add(nums[0]);
        lists.add(first);
        map.add(first);
        //循环处理
        for (int i = 1; i < nums.length; i++) {
            int mapSize = map.size();
            int listSize = lists.size();
            if (nums[i] != nums[i - 1]) {
                map.clear();
                for (int j = 0; j < listSize; j++) {
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.addAll(lists.get(j));
                    newList.add(nums[i]);
                    lists.add(newList);
                    map.add(newList);
                }
            } else {
                for (int j = 0; j < mapSize; j++) {
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.addAll(map.get(j));
                    newList.add(nums[i]);
                    lists.add(newList);
                    map.set(j, newList);
                }
            }
        }
        return lists;
    }

    //递归
    public List<List<Integer>> subsetsWithDup_V2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int pos = nums.length - 1;
        server(nums, pos, lists);
        return lists;
    }

    private List<List<Integer>> server(int[] nums, int pos, List<List<Integer>> lists) {
        List<List<Integer>> copyList = new ArrayList<List<Integer>>();
        if(pos==-1){
            List<Integer> list = new ArrayList<Integer>();
            lists.add(list);
            copyList.add(list);
            return copyList;
        }
        List<List<Integer>> cache = server(nums, pos - 1, lists);
        if(pos==0||nums[pos]!=nums[pos-1]){
            int size = lists.size();
            for(int i=0;i<size;i++){
                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(lists.get(i));
                newList.add(nums[pos]);
                lists.add(newList);
                copyList.add(newList);
            }
            return copyList;
        }
        if(nums[pos]==nums[pos-1]){
            int size = cache.size();
            for(int i=0;i<size;i++){
                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(cache.get(i));
                newList.add(nums[pos]);
                lists.add(newList);
                copyList.add(newList);
            }
            return copyList;
        }
        return copyList;
    }


    public static void main(String[] args) {
        System.out.println(new LintCode_18().subsetsWithDup_V2(new int[]{1, 2, 3}));
    }

}
