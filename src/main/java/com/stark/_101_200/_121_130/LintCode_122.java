package com.stark._101_200._121_130;

import java.util.Stack;

/**
 * Created by Stark on 2017/9/20.
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class LintCode_122 {

    public int largestRectangleArea(int[] height) {
        //栈，用来存放索引
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= height.length; i++) {
            int cur = i < height.length ? height[i] : 0;
            if (stack.isEmpty() || cur > height[stack.peek()]) {
                stack.push(i);
            } else {
                int tem = stack.pop();
                //关键步骤
                res = Math.max(res,height[tem]*(stack.isEmpty()?i:i-stack.peek()-1));
                i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new LintCode_122().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(i);
    }
}
