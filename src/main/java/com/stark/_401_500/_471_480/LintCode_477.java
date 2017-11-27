package com.stark._401_500._471_480;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Stark on 2017/11/24.
 * 给一个二维的矩阵，包含 'X' 和 'O', 找到所有被 'X' 围绕的区域，并用 'X' 填充满。
 */
public class LintCode_477 {
    public void surroundedRegions(char[][] board) {
        // write your code here
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;

        if (m < 3 || n < 3) return;
        boolean[][] visit = new boolean[m][n];
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                List<int[]> cache = new ArrayList<>();
                if (board[i][j] == 'O' && !visit[i][j]) {
                    cache.add(new int[]{i, j});
                    visit[i][j] = true;
                    boolean solve = solve_1(board, i, j, visit, cache);
                    if (!solve) {
                        for (int[] ints : cache) {
                            board[ints[0]][ints[1]] = 'X';
                        }
                    }
                }
            }
        }

    }

    private boolean solve_1(char[][] board, int i, int j, boolean[][] visit, List<int[]> cache) {
        boolean res = false;
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{i, j});
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int x = pop[0];
            int y = pop[1];
            x = pop[0] + 1;
            if (x < board.length) {
                if (board[x][y] == 'O' && !visit[x][y]) {
                    visit[x][y] = true;
                    int[] ints = {x, y};
                    cache.add(ints);
                    stack.add(ints);
                    if (x == board.length - 1 || y == board[0].length - 1 || x == 0 || y == 0) res = true;
                }
            }
            x = pop[0] - 1;
            if (x >= 0) {
                if (board[x][y] == 'O' && !visit[x][y]) {
                    visit[x][y] = true;
                    int[] ints = {x, y};
                    cache.add(ints);
                    stack.add(ints);
                    if (x == board.length - 1 || y == board[0].length - 1 || x == 0 || y == 0) res = true;
                }
            }
            x = pop[0];
            y = pop[1] + 1;
            if (y < board[0].length) {
                if (board[x][y] == 'O' && !visit[x][y]) {
                    visit[x][y] = true;
                    int[] ints = {x, y};
                    cache.add(ints);
                    stack.add(ints);
                    if (x == board.length - 1 || y == board[0].length - 1 || x == 0 || y == 0) res = true;
                }
            }
            y = pop[1] - 1;
            if (y >= 0) {
                if (board[x][y] == 'O' && !visit[x][y]) {
                    visit[x][y] = true;
                    int[] ints = {x, y};
                    cache.add(ints);
                    stack.add(ints);
                    if (x == board.length - 1 || y == board[0].length - 1 || x == 0 || y == 0) res = true;
                }
            }
        }
        return res;
    }

    /*private boolean solve(char[][] board, int i, int j, boolean[][] visit, List<int[]> cache) {
        boolean res = false;
        int x = i + 1;
        int y = j;
        if (x < board.length) {
            if (board[x][y] == 'O' && !visit[x][y]) {
                visit[x][y] = true;
                cache.add(new int[]{x, y});
                if (x == board.length - 1 || y == board[0].length - 1 || x == 0 || y == 0) res = true;
                res = solve(board, x, y, visit, cache) || res;
            }
        }
        x = i - 1;
        if (x >= 0) {
            if (board[x][y] == 'O' && !visit[x][y]) {
                visit[x][y] = true;
                cache.add(new int[]{x, y});
                if (x == board.length - 1 || y == board[0].length - 1 || x == 0 || y == 0) res = true;
                res = solve(board, x, y, visit, cache) || res;
            }
        }
        x = i;
        y = j + 1;
        if (y < board[0].length) {
            if (board[x][y] == 'O' && !visit[x][y]) {
                visit[x][y] = true;
                cache.add(new int[]{x, y});
                if (x == board.length - 1 || y == board[0].length - 1 || x == 0 || y == 0) res = true;
                res = solve(board, x, y, visit, cache) || res;
            }
        }
        y = j - 1;
        if (y >= 0) {
            if (board[x][y] == 'O' && !visit[x][y]) {
                visit[x][y] = true;
                cache.add(new int[]{x, y});
                if (x == board.length - 1 || y == board[0].length - 1 || x == 0 || y == 0) res = true;
                res = solve(board, x, y, visit, cache) || res;
            }
        }
        return res;
    }*/
}
