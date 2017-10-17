package com.stark._601_700._601_610;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Stark on 2017/10/16.
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 */
public class LintCode_602 {
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        //排序 超时 可优化
        int len = envelopes.length;
        for (int i = 0; i < len - 1; i++) {
            int[] min = envelopes[i];
            int minPos = i;
            for (int j = i + 1; j < len; j++) {
                int[] cur = envelopes[j];
                if (cur[1] < min[1]) {
                    min = cur;
                    minPos = j;
                } else if (cur[1] == min[1]) {
                    if (cur[0] < min[0]) {
                        min = cur;
                        minPos = j;
                    }
                }
            }
            int[] temp = envelopes[minPos];
            envelopes[minPos] = envelopes[i];
            envelopes[i] = temp;
        }
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            int[] cur = envelopes[i];
            for (int j = i - 1; j >= 0; j--) {
                int[] cp = envelopes[j];
                if (cur[1] > cp[1] && cur[0] > cp[0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }

        return res + 1;
    }

    public int maxEnvelopes_V2(int[][] envelopes) {
        if (envelopes.length <= 1) return envelopes.length;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] nums1, int[] nums2) {
                int res = nums1[0] - nums2[0];
                if (res != 0) return res;
                return nums2[1] - nums1[1];
            }
        });

        int count = 1;
        for (int i = 0; i < envelopes.length; i++) {
            int left = 0;
            int right = count - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (envelopes[i][1] > envelopes[mid][1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            envelopes[left] = envelopes[i];
            if (left == count) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LintCode_602 lintCode_602 = new LintCode_602();
        int i = lintCode_602.maxEnvelopes(new int[][]{new int[]{5, 4}, new int[]{6, 4},
                new int[]{6, 7}, new int[]{2, 3}});
        System.out.println(i);
    }
}
