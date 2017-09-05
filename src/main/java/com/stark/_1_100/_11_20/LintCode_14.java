package com.stark._1_100._11_20;

/**
 * Created by Stark on 2017/9/5.
 * 给定一个排序的整数数组（升序）和一个要查找的整数target，
 * 用O(logn)的时间查找到target第一次出现的下标（从0开始），
 * 如果target不存在于数组中，返回-1。
 */
public class LintCode_14 {

    //递归算法
    public int binarySearch_V1(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int begin, int end) {
        if (begin == end && target == nums[begin]) {
            return begin;
        }
        if (begin == end && target != nums[begin]) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            int result = mid;
            //寻找第一次出现
            for(;result>0;result--){
                if(nums[result-1]<target) break;
            }
            return result;
        } else if (target > nums[mid]) {
            return search(nums, target, mid + 1, end);
        } else {
            return search(nums, target, begin, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,3,4,5,6,7,8,8,9};
        System.out.println(new LintCode_14().binarySearch_V1(nums,8));
    }

}
