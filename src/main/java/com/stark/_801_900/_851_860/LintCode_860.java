package com.stark._801_900._851_860;


import java.util.ArrayList;
import java.util.List;

public class LintCode_860 {

    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        int m = grid.length;
        if (m <= 0) return 0;
        int n = grid[0].length;
        List<String> paths = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1) {
                    StringBuffer sb = new StringBuffer();
                    dfs(grid, i, j,i,j,sb);
                    String path = sb.toString();
                    if(!paths.contains(path)){
                        paths.add(path);
                    }
                }
            }
        }
        return paths.size();
    }

    private void dfs(int[][] grid, int i, int j,int beginI,int beginJ,StringBuffer sb) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]!=1) {
            return;
        }
        grid[i][j] = 0;
        sb.append(i-beginI).append(j-beginJ);
        dfs(grid, i - 1, j,beginI,beginJ,sb);
        dfs(grid, i + 1, j,beginI,beginJ,sb);
        dfs(grid, i, j + 1,beginI,beginJ,sb);
        dfs(grid, i, j - 1,beginI,beginJ,sb);
    }

    public static void main(String[] args) {
        LintCode_860 lintCode_860 = new LintCode_860();
        int[][] grid = new int[][]{
                {1,1,1,0,1},
                {1,1,0,0,0},
                {0,0,1,1,1},
                {1,0,1,1,0}};
        System.out.println(lintCode_860.numberofDistinctIslands(grid));
    }
}
