package com.stark._601_700._691_700;

/**
 * Created by Stark on 2017/11/27.
 * 给 m 个数组, 每一个数组均为升序. 现在你可以从两个不同的数组中挑选两个整数(每一个数组选一个)并且计算差值.
 * 我们将两个整数 a 和 b 之间的差定义为它们的绝对差 |a - b|. 你的任务是去找到最大的差值.
 */
public class LintCode_698 {
    public int maxDiff(int[][] arrs) {
        // write your code here
        int len = arrs.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                max = Math.max(max, arrs[j][arrs[j].length - 1] - arrs[i][0]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LintCode_698 test = new LintCode_698();
        int i = test.maxDiff(new int[][]{{2, 3, 4, 5, 6, 7, 8, 9}, {1, 10}, {-1, 200}});
        System.out.println(i);
    }
}
