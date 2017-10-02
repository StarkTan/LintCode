package com.stark._301_400._391_400;

/**
 * Created by Stark on 2017/10/2.
 * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），
 * 请找出该数组中的最长上升连续子序列。（最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 */
public class LintCode_397 {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        int len = A.length;
        if (len < 2) {
            return len;
        }
        String dir = ""; // "" up down
        int begin = 0;
        int end = 1;
        int max = 1;
        while (end < len) {
            if (A[end] == A[end - 1]) {
                max = Math.max(max, end - begin);
                begin = end;
                end++;
                dir = "";
            } else if (A[end] > A[end - 1]) {
                switch (dir) {
                    case "":
                        dir = "up";
                        end++;
                        break;
                    case "up":
                        end++;
                        break;
                    default:
                        max = Math.max(max, end - begin);
                        begin = end - 1;
                        end++;
                        dir = "up";
                        break;
                }
            } else {
                switch (dir) {
                    case "":
                        dir = "down";
                        end++;
                        break;
                    case "down":
                        end++;
                        break;
                    default:
                        max = Math.max(max, end - begin);
                        begin = end - 1;
                        end++;
                        dir = "down";
                        break;
                }
            }
        }
        return Math.max(max,end-begin);
    }
}
