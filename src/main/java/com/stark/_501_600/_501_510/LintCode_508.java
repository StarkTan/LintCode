package com.stark._501_600._501_510;

/**
 * Created by Stark on 2017/9/17.
 * 给你一个没有排序的数组，请将原数组就地重新排列满足如下性质
 * <p>
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 */
public class LintCode_508 {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len-1;i++){
            for(int j =i+1;j<len;j++){
                if((i%2==0&&nums[i]>nums[j])||
                        (i%2!=0&&nums[i]<nums[j])){
                    int temp =nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }
}
