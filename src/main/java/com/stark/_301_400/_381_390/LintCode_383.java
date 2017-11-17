package com.stark._301_400._381_390;

/**
 * Created by Stark on 2017/11/17.
 * 给定 n 个非负整数 a1, a2, ..., an, 每个数代表了坐标中的一个点 (i, ai)。
 * 画 n 条垂直线，使得 i 垂直线的两个端点分别为(i, ai)和(i, 0)。
 * 找到两条线，使得其与 x 轴共同构成一个容器，以容纳最多水。
 */
public class LintCode_383 {
    public int maxArea(int[] heights) {
        // write your code here
        int res = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int width = j - i;
                int height = Math.min(heights[i], heights[j]);
                res = Math.max(res, width * height);
            }
        }
        return res;
    }
}
