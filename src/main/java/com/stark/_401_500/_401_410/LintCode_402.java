package com.stark._401_500._401_410;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/2.
 * 给定一个整数数组，请找出一个连续子数组，使得该子数组的和最大。输出答案时，
 * 请分别返回第一个数字和最后一个数字的下标。（如果两个相同的答案，请返回其中任意一个）
 */
public class LintCode_402 {
    public List<Integer> continuousSubarraySum(int[] A) {
        // write your code here
        /* 提交溢出
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int max = A[0];
        int len = A.length;
        int[][] dp = new int[len][len];
        dp[0][0] = A[0];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (j == 0) continue;
                dp[i][j] = dp[i][j - 1] + A[j];
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    left = i;
                    right = j;
                }
            }
        }

        res.add(left);
        res.add(right);
        return res;*/
        /* 双层循环 超时
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int max = A[0];
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int cur = 0;
            for (int j = i; j < len; j++) {
                cur += A[j];
                if (cur > max) {
                    max = cur;
                    left = i;
                    right = j;
                }
            }
        }

        res.add(left);
        res.add(right);
        return res;*/
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int curLeft = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int len = A.length;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            cur += A[i];
            if (cur > max) {
                max = cur;
                left = curLeft;
                right = i;
            }
            if (cur <= 0) {
                curLeft = i + 1;
                cur = 0;
            }
        }

        res.add(left);
        res.add(right);
        return res;
    }
}
