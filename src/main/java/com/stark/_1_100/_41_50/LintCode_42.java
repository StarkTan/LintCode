package com.stark._1_100._41_50;

import java.util.List;

/**
 * Created by Stark on 2017/9/14.
 * 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
 * 每个子数组的数字在数组中的位置应该是连续的。
 * 返回最大的和。
 */
public class LintCode_42 {
    public int maxTwoSubArrays(List<Integer> nums) {
        int max_right = Integer.MIN_VALUE;
        int curMax_right = 0;
        int max_left = Integer.MIN_VALUE;
        int curMax_left = 0;
        int len = nums.size();
        int[] max_rights = new int[len];
        int[] max_lefts = new int[len];
        for(int i=0;i<len;i++){
            curMax_left += nums.get(i);
            curMax_right += nums.get(len-1-i);
            max_left = Math.max(max_left,curMax_left);
            if(curMax_left<0){
                curMax_left=0;
            }
            max_right = Math.max(max_right,curMax_right);
            if(curMax_right<0){
                curMax_right=0;
            }
            max_lefts[i]=max_left;
            max_rights[len-1-i]=max_right;
        }
        int res = Integer.MIN_VALUE;

        for(int i=0;i<len-1;i++){
            res = Math.max(res,max_lefts[i]+max_rights[i+1]);
        }
        return res;
    }
}
