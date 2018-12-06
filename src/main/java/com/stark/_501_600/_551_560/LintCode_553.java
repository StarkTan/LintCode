package com.stark._501_600._551_560;

/**
 * Created by Stark on 2018/4/11.
 * 给一个二维矩阵, 每一个格子都可能是一堵墙 W, 一个敌人 E 或者空 0 (数字 '0'), 返回你可以用一个炸弹杀死的最大敌人数.
 * 炸弹会杀死所有在同一行和同一列没有墙阻隔的敌人, 因为墙比较坚固难以摧毁.
 * TODO
 */
public class LintCode_553 {
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        int height = grid.length;
        if (height == 0) return 0;
        int width = grid[0].length;
        if (width == 0) return 0;
        int[][] x = new int[height][width];

        for (int i = 0; i < height; i++) {
            int last_wall = -1;
            int enemy_count = 0;
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 'E') enemy_count++;
                if (grid[i][j] == 'W') {
                    for (int k = last_wall + 1; k <= j; k++) {
                        x[i][k] = grid[i][k] == '0' ? enemy_count : 0;
                    }
                    last_wall = j;
                    enemy_count = 0;
                }
            }
            for (int k = last_wall + 1; k < width; k++) {
                x[i][k] = grid[i][k] == '0' ? enemy_count : 0;
            }
        }

        int res = 0;
        for (int j = 0; j < width; j++) {

            int last_wall = -1;
            int enemy_count = 0;

            for (int i = 0; i < height; i++) {
                if (grid[i][j] == 'E') enemy_count++;
                if (grid[i][j] == 'W') {
                    for (int k = last_wall + 1; k < i; k++) {
                        if (grid[k][j] == '0') {
                            x[k][j] += enemy_count;
                            res = x[k][j] > res ? x[k][j] : res;
                        } else {
                            x[k][j] = 0;
                        }
                    }
                    last_wall = i;
                    enemy_count = 0;
                }
            }
            for (int k = last_wall + 1; k < height; k++) {
                if (grid[k][j] == '0') {
                    x[k][j] += enemy_count;
                    res = x[k][j] > res ? x[k][j] : res;
                } else {
                    x[k][j] = 0;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new LintCode_553().maxKilledEnemies(new char[][]{{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}}));
    }
}
