package com.stark._301_400._391_400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/11/2.
 * 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
 * 设计一个算法来找到最大的利润。你最多可以完成 k 笔交易。
 */
public class LintCode_393 {
    public int maxProfit(int K, int[] prices) {
        // write your code here
        int len = prices.length;
        if (len == 0) return 0;
        if (K > len) return solveMaxProfit(prices);
        //全局变量，k次交易的最大值，可以包含最后一次的差值
        int[] g = new int[K + 1];
        //全局变量，k次交易的最大值，必须包含最后一次的差值
        int[] l = new int[K + 1];
        for (int i = 0; i < len - 1; ++i) {
            int diff = prices[i + 1] - prices[i];
            for (int j = K; j >= 1; --j) {
                l[j] = Math.max(g[j - 1] + Math.max(diff, 0), l[j] + diff);
                g[j] = Math.max(g[j], l[j]);
            }
        }
        return g[K];
    }

    private int solveMaxProfit(int[] prices) {

        int res = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
