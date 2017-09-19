package com.stark._101_200._161_170;

/**
 * Created by Stark on 2017/9/19.
 * 有n个气球，编号为0到n-1，每个气球都有一个分数，存在nums数组中。
 * 每次吹气球i可以得到的分数为 nums[left] * nums[i] * nums[right]，
 * left和right分别表示i气球相邻的两个气球。当i气球被吹爆后，其左右两气球即为相邻。要求吹爆所有气球，得到最多的分数。
 */
public class LintCode_168 {
    public int maxCoins(int[] nums){
        int len = nums.length;
        if(len==0){
            return 0;
        }

        //dp[i][j]表示从i到j的最大值
        int[][] dp = new int[len+2][len+2];
        //用于记录已经计算过的数据
        int[][] visit = new int[len+2][len+2];
        //在数组两边加1
        int[] numsPlus = new int[len+2];
        for(int i = 1;i<len + 1;i++){
            numsPlus[i] = nums[i - 1];
        }
        numsPlus[0] = 1;
        numsPlus[len+1] = 1;

        int result = search(dp , visit , numsPlus , 1 , len);

        return result;
    }
    private int search(int[][] dp, int[][] visit, int[] numsPlus, int start, int end) {
        if(visit[start][end] == 1){
            return dp[start][end];
        }
        int res = 0;
        for(int i = start ; i<=end ; i++){
            //全部是3个数的问题
            int mid = numsPlus[start-1]*numsPlus[i]*numsPlus[end+1];
            int right = search(dp , visit , numsPlus , start , i - 1);
            int left = search(dp , visit , numsPlus , i + 1 , end);
            res = Math.max(res , mid + right + left);
        }
        visit[start][end] = 1;
        dp[start][end] = res;
        return res;
    }
}
