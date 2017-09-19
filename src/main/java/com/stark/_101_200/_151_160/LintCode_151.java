package com.stark._101_200._151_160;

/**
 * Created by Stark on 2017/9/19.
 * 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
 * 设计一个算法来找到最大的利润。你最多可以完成两笔交易。
 */
public class LintCode_151 {

    public int maxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        if (len < 2) {
            return res;
        }
        //首尾收缩去掉无用数据
        int begin  = 0;
        int end = len-1;
        for(int i=begin;i<len-1;i++){
            if(prices[i]<prices[i+1]){
                begin = i;
                break;
            }
        }
        for(int i=end;i>0;i--){
            if(prices[i]>prices[i-1]){
                end = i;
                break;
            }
        }
        if(end==begin){
            return 0;
        }

        int[] left = new int[end-begin+1];//0-i
        int[] right = new int[end-begin+1];//i-len-1

        for (int i = begin; i <=end; i++) {
            left[i-begin] = getMax(begin, i, prices);
            right[i-begin] = getMax(i, end, prices);
        }
        for(int i=0;i<=end-begin;i++){
            res = Math.max(res,left[i]+right[i]);
        }
        return res;
    }

    private int getMax(int begin, int end, int[] prices) {
        int min = prices[begin];
        int res = 0;
        for(int i=begin+1;i<=end;i++){
            min = Math.min(min,prices[i]);
            res = Math.max(res,prices[i]-min);
        }
        return res;
    }
}
