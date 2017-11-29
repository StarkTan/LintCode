package com.stark._101_200._141_150;

/**
 * Created by Stark on 2017/11/28.
 * 假设有一个数组，它的第i个元素是一个给定的股票在第i天的价格。设计一个算法来找到最大的利润。
 * 你可以完成尽可能多的交易(多次买卖股票)。然而,你不能同时参与多个交易(你必须在再次购买前出售股票)。
 */
public class LintCode_150 {

    public int maxProfit(int[] prices) {
        // write your code here
        int res = 0;
        if (prices.length == 0) return res;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i];
            int profile = cur - pre;
            if (profile > 0) res += profile;
            pre = cur;
        }
        return res;
    }
}
