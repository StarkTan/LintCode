package com.stark._401_500._431_440;

import java.util.Stack;

/**
 * Created by Stark on 2017/11/2.
 */
public class LintCode_433 {
    public int numIslands(boolean[][] grid) {
        // write your code here
        int res = 0;
        int m = grid.length;
        if (m <= 0) return res;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(boolean[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || !grid[i][j]) {
            return;
        }
        grid[i][j] = false;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
