package com.stark._301_400._381_390;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/10/2.
 * 给定 n 和 k，求123..n组成的排列中的第 k 个排列。
 */
public class LintCode_388 {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = i+1;
        }
        while (k>1){
            change(nums,n);
            k--;
        }
        return Arrays.toString(nums).replace("[","").replace("]","").replace(", ","");
    }
    private void change(int[] nums,int n) {
        int change = n-1;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                change = i-1;
                break;
            }
        }
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[change]){
                int temp =nums[i];
                nums[i] = nums[change];
                nums[change] = temp;
                break;
            }
        }
        int begin = change+1;
        int end = n-1;
        while (begin<end){
            int temp =nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
