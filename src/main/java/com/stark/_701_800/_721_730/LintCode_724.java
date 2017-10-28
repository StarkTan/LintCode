package com.stark._701_800._721_730;

/**
 * Created by Stark on 2017/10/27.
 * 给出一个整数数组，写一个程序把这个整数数组分成S1跟S2两部分，
 * 使S1中的和跟S2中的和的绝对值最小。
 * 如果有一个一个整数数组 S 有 n 个数，如果Subset1有 m 个数，
 * Subset2必须有 n-m 个数并且 abs(sum(Subset1) – sum(Subset2)) 应该最小
 * TODO 网页解题出问题，答案不对，下次提交
 */
public class LintCode_724 {
    public int findMin(int[] arr) {
        // write your code here
        int sum = 0;
        for (int i : arr) sum += i;
        int half = sum / 2;

        //背包
        int[][] dp = new int[half + 1][arr.length];
        for (int i = 1; i <= half; i++) {
            if (arr[0] <= i) {
                dp[i][0] = arr[0];
            }
        }
        for (int i = 1; i <= half; i++) {
            for (int j = 1; j < arr.length; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= arr[j]) {
                    dp[i][j] = Math.max(dp[i][j], arr[j] + dp[i - arr[j]][j - 1]);
                }
            }
        }
        int halfMax = dp[half][arr.length - 1];
        return Math.abs(sum - 2 * halfMax);
    }

    public static void main(String[] args) {
        LintCode_724 test = new LintCode_724();
        int min = test.findMin(new int[]{616,202,595,876,388,120,238,296});
        System.out.println(min);
    }
}
