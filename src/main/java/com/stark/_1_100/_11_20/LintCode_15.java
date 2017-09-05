package com.stark._1_100._11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/9/5.
 * 给定一个数字列表，返回其所有可能的排列。
 */
public class LintCode_15 {
    //递归实现,默认不重复
    public List<List<Integer>> permute_V1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            lists.add(new ArrayList<Integer>());
            return lists;
        }
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }
        List<Integer> ocu = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(ocu.contains(cur)){
                continue;
            }else {
                ocu.add(cur);
            }
            int[] nextNums = new int[nums.length - 1];
            for (int j = 0, k = 0; j < nums.length; j++) {
                if (j == i) continue;
                nextNums[k] = nums[j];
                k++;
            }
            List<List<Integer>> lists1 = permute_V1(nextNums);
            for (List<Integer> list : lists1) {
                list.add(cur);
            }
            lists.addAll(lists1);
        }
        return lists;
    }
    public List<List<Integer>> permute_V2(int[] nums){
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums.length==0){
            lists.add(new ArrayList<Integer>());
            return lists;
        }
        //升序排序
        Arrays.sort(nums);
        //存入数据
        saveData(nums,lists);
        while(true){
            //第一步:从后向前找到第一对升序的位置 i，i+1
            int i = nums.length-2;
            for(;i>=0;i--){
                if (nums[i+1]>nums[i]){
                    break;
                }
            }
            if(i==-1){
                break; //全升序结束
            }
            //第二步:反向找到第一个比i大的数，交换
            int j=nums.length-1;
            for(;j>i;j--){
                if(nums[j]>nums[i])break;
            }
            int temp = nums[i];
            nums[i] =nums[j];
            nums[j] = temp;
            //第三步:反序i到len-1
            reserve(nums,i+1,nums.length-1);
            //存入数据
            saveData(nums,lists);
        }
        return lists;
    }

    private void reserve(int[] nums, int begin, int end) {
        while(begin<end){
            int temp = nums[begin];
            nums[begin] =nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }

    private void saveData(int[] nums, List<List<Integer>> lists) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i :nums){
            list.add(i);
        }
        lists.add(list);
    }

    public static void main(String[] args) {
        int size = new LintCode_15().permute_V1(new int[]{1, 2, 2,2}).size();
        System.out.println(size);
    }
}
