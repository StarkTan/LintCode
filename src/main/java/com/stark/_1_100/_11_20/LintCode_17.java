package com.stark._1_100._11_20;

import com.stark._1_100._1_10.LintCode_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/9/5.
 * 给定一个含不同整数的集合，返回其所有的子集,非降序排列
 */
public class LintCode_17 {

    //递归
    public List<List<Integer>> subsets_V1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length == 0) {
            lists.add(new ArrayList<Integer>());
            return lists;
        } else if (nums.length == 1) {
            lists.add(new ArrayList<Integer>());
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[0]);
            lists.add(list);
            return lists;
        } else {
            int cur = nums[nums.length - 1];
            int[] nextNums = new int[nums.length - 1];
            for (int i = 0; i < nums.length - 1; i++) {
                nextNums[i] = nums[i];
            }
            List<List<Integer>> lists1 = subsets_V1(nextNums);
            int size = lists1.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list1 = new ArrayList<Integer>();
                for (int j : lists1.get(i)) {
                    list1.add(j);
                }
                lists1.get(i).add(cur);
                lists1.add(list1);
            }
            lists.addAll(lists1);
            return lists;
        }
    }

    //非递归
    public List<List<Integer>> subsets_V2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        lists.add(new ArrayList<Integer>());
        List<Integer> repeat = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int size = lists.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list1 = new ArrayList<Integer>();
                for (int k : lists.get(j)) {
                    list1.add(k);
                }
                list1.add(cur);
                lists.add(list1);
                repeat.add(cur);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_17().subsets_V1(new int[]{1, 2, 3}));
    }
}
