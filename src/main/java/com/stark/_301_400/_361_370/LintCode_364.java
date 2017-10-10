package com.stark._301_400._361_370;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Stark on 2017/10/10.
 * Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1,
 * compute how much water it is able to trap after raining.
 */
public class LintCode_364 {
    public int trapRainWater(int[][] heights) {
        // write your code here
        //LintCode 为1.7版本，无法使用Lambda
        Comparator<Pos> comp = new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                if (o1.height > o2.height) {
                    return 1;
                } else if (o1.height < o2.height) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        int res = 0;
        Queue<Pos> queue = new PriorityQueue<>(10, comp);
        int m = heights.length;
        if (m == 0) {
            return res;
        }
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        //将边界放入堆中
        for (int i = 0; i < m; i++) {
            if (!visited[i][0]) {
                visited[i][0] = true;
                Pos pos = new Pos(i, 0, heights[i][0]);
                queue.add(pos);
            }
            if (!visited[i][n - 1]) {
                visited[i][n - 1] = true;
                Pos pos = new Pos(i, n - 1, heights[i][n - 1]);
                queue.add(pos);
            }
        }
        for (int j = 0; j < n; j++) {
            if (!visited[0][j]) {
                visited[0][j] = true;
                Pos pos = new Pos(0, j, heights[0][j]);
                queue.add(pos);
            }
            if (!visited[m - 1][j]) {
                visited[m - 1][j] = true;
                Pos pos = new Pos(m - 1, j, heights[m - 1][j]);
                queue.add(pos);
            }
        }
        int curHeight = 0;
        while (!queue.isEmpty()) {
            Pos peek = queue.peek();
            int x = peek.x;
            int y = peek.y;
            int height = peek.height;
            if (height > curHeight) {
                curHeight++;
            } else if (height == curHeight) {
                if (x - 1 > 0 && !visited[x - 1][y]) {
                    int posHeight = heights[x - 1][y];
                    visited[x - 1][y] = true;
                    if (posHeight < curHeight) {
                        res += curHeight - posHeight;
                        queue.add(new Pos(x - 1, y, curHeight));
                    } else {
                        queue.add(new Pos(x - 1, y, posHeight));
                    }
                }
                if (x + 1 < m - 1 && !visited[x + 1][y]) {
                    int posHeight = heights[x + 1][y];
                    visited[x + 1][y] = true;
                    if (posHeight < curHeight) {
                        res += curHeight - posHeight;
                        queue.add(new Pos(x + 1, y, curHeight));
                    } else {
                        queue.add(new Pos(x + 1, y, posHeight));
                    }
                }
                if (y - 1 > 0 && !visited[x][y - 1]) {
                    int posHeight = heights[x][y - 1];
                    visited[x][y - 1] = true;
                    if (posHeight < curHeight) {
                        res += curHeight - posHeight;
                        queue.add(new Pos(x, y - 1, curHeight));
                    } else {
                        queue.add(new Pos(x, y - 1, posHeight));
                    }
                }
                if (y + 1 < n - 1 && !visited[x][y + 1]) {
                    int posHeight = heights[x][y + 1];
                    visited[x][y + 1] = true;
                    if (posHeight < curHeight) {
                        res += curHeight - posHeight;
                        queue.add(new Pos(x, y + 1, curHeight));
                    } else {
                        queue.add(new Pos(x, y + 1, posHeight));
                    }
                }
                queue.remove(peek);
            } else {
                break;
            }
        }
        return res;
    }


    class Pos {
        public int x;
        public int y;
        public int height;

        public Pos(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        LintCode_364 lintCode_364 = new LintCode_364();
        int[] one = new int[]{1, 4, 3, 1, 3, 2};
        int[] two = new int[]{3, 2, 1, 3, 2, 4};
        int[] three = new int[]{2, 3, 3, 2, 3, 1};
        int[][] test = new int[][]{one, two, three};
        int i = lintCode_364.trapRainWater(test);
        System.out.println(i);

    }
}
