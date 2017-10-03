package com.stark._101_200._111_120;

/**
 * Created by Stark on 2017/10/3.
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
 * 判断你是否能到达数组的最后一个位置。
 */
public class LintCode_116 {
    public boolean canJump(int[] A) {
        // write your code here
        //贪心
        /*int len = A.length;
        boolean res = true;
        for (int i = len - 2; i >= 0; i--) {
            if (A[i] == 0) {
                res = false;
                int zero = i--;
                while (!res && i > -1) {
                    if (A[i] > zero-i) {
                        res = true;
                        break;
                    }else {
                        i--;
                    }
                }
            }
        }
        return res;*/

        //动态规划
        int len = A.length;
        int[] res = new int[len];
        res[0] = A[0];
        for (int i = 1; i < len; i++) {
            if (res[i - 1] >= i)
                res[i] = Math.max(A[i] + i, res[i - 1]);
            else
                res[i] = 0;
        }
        return res[len - 1] >= len-1;
    }
}
