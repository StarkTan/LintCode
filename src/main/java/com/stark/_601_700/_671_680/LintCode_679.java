package com.stark._601_700._671_680;

import com.stark._401_500._421_430.LintCode_427;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stark on 2017/11/28.
 * 现在每一个格子都包含了一个值,所以每条路径都有一个值,找到所有值不同的路径的和
 */
public class LintCode_679 {

    public int uniqueWeightedPaths(int[][] grid) {
        // write your codes here
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if(n==0) return 0;
        int[][][] dp = new int[m + 1][n + 1][];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = new int[]{grid[i - 1][j - 1]};
                } else {
                    int[] up = dp[i - 1][j];
                    int[] left = dp[i][j - 1];
                    Set<Integer> set = new HashSet<>();
                    if (up != null) for (int cur : up) set.add(cur);
                    if (left != null) for (int cur : left) set.add(cur);
                    int[] ints = new int[set.size()];
                    int pos = 0;
                    for (int cur : set) ints[pos++] = cur + grid[i-1][j-1];
                    dp[i][j] = ints;
                }
            }
        }
        int[] ints = dp[m][n];
        int res = 0;
        for (int cur : ints) res += cur;
        return res;
    }


    public static void main(String[] args) {
        LintCode_679 test = new LintCode_679();
        int i = test.uniqueWeightedPaths(new int[][]{{1, 1, 2}, {1, 2, 3}, {3, 2, 4}});
        System.out.println(i);
    }
}
