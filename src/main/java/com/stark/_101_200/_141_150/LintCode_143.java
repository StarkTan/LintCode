package com.stark._101_200._141_150;

import java.util.Arrays;

/**
 * Created by Stark on 2017/10/27.
 * 给定一个有n个对象（包括k种不同的颜色，并按照1到k进行编号）的数组，
 * 将对象进行分类使相同颜色的对象相邻，并按照1,2，...k的顺序进行排序。
 */
public class LintCode_143 {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int begin = 0;
        int cur = 1;
        solve(colors, begin, cur, k);
    }

    private void solve(int[] colors, int begin, int cur, int k) {
        if (cur == k) return;
        int pos = begin;
        for (int i = begin; i < colors.length; i++) {
            if (colors[i] == cur) {
                if (i == pos) {
                    pos++;
                } else {
                    int temp = colors[pos];
                    colors[pos] = colors[i];
                    colors[i] = temp;
                    pos++;
                }
            }
        }
        solve(colors, pos, cur + 1, k);
    }

    public static void main(String[] args) {
        LintCode_143 test = new LintCode_143();
        int[] ints = {3, 2, 2, 1, 4};
        test.sortColors2(ints, 4);
        System.out.println(Arrays.toString(ints));
    }
}
