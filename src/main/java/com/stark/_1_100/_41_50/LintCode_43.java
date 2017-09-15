package com.stark._1_100._41_50;

/**
 * Created by Stark on 2017/9/15.
 * 给定一个整数数组和一个整数 k，找出 k 个不重叠子数组使得它们的和最大。每个子数组的数字在数组中的位置应该是连续的。
 * 返回最大的和。
 */
public class LintCode_43 {
    public int maxSubArray(int[] nums, int k) {
        int len = nums.length;
        Integer[][] localMax = new Integer[len + 1][k + 1];
        Integer[][] globalMax = new Integer[len + 1][k + 1];
        //初始化数据
        globalMax[0][1]=Integer.MIN_VALUE;
        globalMax[0][0]=0;
        localMax[0][0]=0;
        int curMax =0;
        for (int i = 1; i <= len; i++) {
            localMax[i][1] = nums[i-1];
            curMax += nums[i-1];
            globalMax[i][1] = Math.max(globalMax[i-1][1],curMax);
            if(curMax<0){
                curMax=0;
            }
        }
        for(int i =1;i<=k;i++){
            localMax[i][i] = localMax[i-1][i-1]+nums[i-1];
            globalMax[i][i] = globalMax[i-1][i-1]+nums[i-1];
        }


        for (int j = 2; j <= k; j++){
            for (int i = j+1; i <= len; i++) {
                localMax[i][j] = Math.max(localMax[i - 1][j] + nums[i - 1], globalMax[i - 1][j - 1] + nums[i - 1]);
                globalMax[i][j] = Math.max(globalMax[i - 1][j], localMax[i][j]);
            }
        }
        return globalMax[len][k];
    }

    public static void main(String[] args) {
        int i = new LintCode_43().maxSubArray(new int[]{5,4},2 );
        System.out.println(i);
    }
}

