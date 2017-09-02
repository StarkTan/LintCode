package com.stark._1_100._1_10;

/**
 * Created by Stark on 2017/8/29.
 * 寻找第k大的数
 *
 */
public class LintCode_5 {
    //使用快排原理来做
    public int kthLargestElement_V1(int k, int[] nums) {
        int begin = 0;
        int end = nums.length-1;

        fastSort(k,nums,begin,end);
        return nums[k-1];
    }

    private void fastSort(int k, int[] nums, int begin, int end) {
        if(begin>=end) return;
        if(k-1>end||k-1<begin) return;
        //进行一次排序
        int i = begin+1;
        int j = end;
        int key = nums[begin];
        int pos = begin;
        boolean right = true; //初始向左
        while(i<=j){
            if(right){
                if(nums[j]>key){
                    nums[pos] = nums[j];
                    pos =j;
                    right = false;
                }
                j--;
            }else {
                if(nums[i]<key){
                    nums[pos] = nums[i];
                    pos =i;
                    right = true;
                }
                i++;
            }
        }
        nums[pos] = key;
        //开始递归
        fastSort(k,nums,begin,pos-1);
        fastSort(k,nums,pos+1,end);
    }

    //使用堆排原理来做
    public int kthLargestElement_V2(int k, int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_5().kthLargestElement_V1(3,new int[]{1,2,3,4,5,6,9}));
    }
}
