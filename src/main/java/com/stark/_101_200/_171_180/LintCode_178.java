package com.stark._101_200._171_180;

/**
 * Created by Stark on 2017/10/27.
 * 给出 n 个节点，标号分别从 0 到 n - 1 并且给出一个 无向 边的列表 (给出每条边的两个顶点),
 * 写一个函数去判断这张｀无向｀图是否是一棵树
 * 你可以假设我们不会给出重复的边在边的列表当中. 无向边　[0, 1] 和 [1, 0]　是同一条边，
 * 因此他们不会同时出现在我们给你的边的列表当中。
 */
public class LintCode_178 {
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        //保证边数正确
        if (edges.length != n - 1) return false;
        //保证每个边能够被0访问到
        boolean[] res = new boolean[n];
        res[0] = true;
        int time = 1;
        int count = 0;
        while (time < n) {
            for (int i = 0; i < n-1; i++) {
                int[] nums = edges[i];
                if (nums == null) continue;
                if (res[nums[0]] || res[nums[1]]) {
                    res[nums[0]] = true;
                    res[nums[1]] = true;
                    edges[i] = null;
                    count++;
                }
            }
            if (count == n - 1) break;
            time++;
        }
        return count == n - 1;
    }

    public static void main(String[] args) {
        LintCode_178 test = new LintCode_178();
        boolean b = test.validTree(5, new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{1, 4}});
        System.out.println(b);
    }
}
