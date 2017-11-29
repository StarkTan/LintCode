package com.stark._101_200._141_150;

/**
 * Created by Stark on 2017/11/28.
 * 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
 * 如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
 */
public class LintCode_149 {

    public int maxProfit(int[] prices) {
        // write your code here
        int res = 0;
        if (prices.length == 0) return 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) res = Math.max(res, prices[i] - min);
            else min = prices[i];
        }
        return res;
    }
}
