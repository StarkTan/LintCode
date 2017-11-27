package com.stark._101_200._121_130;

/**
 * Created by Stark on 2017/11/24.
 * 给出一个二维的字母板和一个单词，寻找字母板网格中是否存在这个单词。
 * 单词可以由按顺序的相邻单元的字母组成，其中相邻单元指的是水平或者垂直方向相邻。每个单元中的字母最多只能使用一次。
 */
public class LintCode_123 {
    public boolean exist(char[][] board, String word) {
        // write your code here
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == chars[0]) {
                    boolean[][] visit = new boolean[m][n];
                    visit[i][j] = true;
                    boolean exist = solve(board, m, n, chars, 1, len - 1, visit, i, j);
                    if (exist) return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, int m, int n,
                          char[] chars, int cur, int end,
                          boolean[][] visit, int i, int j) {
        if (cur > end) return true;

        if (i + 1 < m && board[i + 1][j] == chars[cur] && !visit[i + 1][j]) {
            visit[i + 1][j] = true;
            boolean solve = solve(board, m, n, chars, cur + 1, end, visit, i + 1, j);
            if (solve) return true;
            visit[i + 1][j] = false;

        }
        if (i - 1 >= 0 && board[i - 1][j] == chars[cur] && !visit[i - 1][j]) {
            visit[i - 1][j] = true;
            boolean solve = solve(board, m, n, chars, cur + 1, end, visit, i - 1, j);
            if (solve) return true;
            visit[i - 1][j] = false;

        }
        if (j + 1 < n && board[i][j + 1] == chars[cur] && !visit[i][j + 1]) {
            visit[i][j + 1] = true;
            boolean solve = solve(board, m, n, chars, cur + 1, end, visit, i, j + 1);
            if (solve) return true;
            visit[i][j + 1] = false;

        }
        if (j - 1 >= 0 && board[i][j - 1] == chars[cur] && !visit[i][j - 1]) {
            visit[i][j - 1] = true;
            boolean solve = solve(board, m, n, chars, cur + 1, end, visit, i, j - 1);
            if (solve) return true;
            visit[i][j - 1] = false;

        }
        return false;
    }
}
