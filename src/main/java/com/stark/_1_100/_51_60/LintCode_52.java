package com.stark._1_100._51_60;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个整数数组来表示排列，找出其之后的一个排列。
 * 注意事项
 * 排列中可能包含重复的整数
 */
public class LintCode_52 {
    public int[] nextPermutation(int[] nums) {

        int len = nums.length;
        int change = len;//改变点
        for(int i=len-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                change = i;
                break;
            }
        }
        if(change==len){
            //全部反转
            myRevorse(0,len-1,nums);
            return nums;
        }
        int upper = len;
        for(int i=len-1;i>=0;i--){
            if(nums[i]>nums[change]){
                upper = i;
                break;
            }
        }
        //交换
        int temp = nums[change];
        nums[change] =nums[upper];
        nums[upper]=temp;
        //部分倒转
        int begin =change+1;
        int end = len-1;
        myRevorse(begin,end,nums);
        return nums;
    }

    private void myRevorse(int begin, int end, int[] nums) {
        while(begin<end){
            int temp = nums[begin];
            nums[begin] =nums[end];
            nums[end]=temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] ints = new LintCode_52().nextPermutation(new int[]{1, 2, 1});
        System.out.println(ints);
    }

}
