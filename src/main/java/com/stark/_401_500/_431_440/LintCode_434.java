package com.stark._401_500._431_440;

import com.stark.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class LintCode_434 {
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<>();
        if (operators == null || operators.length == 0) return res;
        int[] ilands = new int[operators.length];
        int[] nums = new int[operators.length];
        int[][] arounds = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int num = 0;
        for (int i = 0; i < operators.length; i++) {
            num++;
            int x = operators[i].x;
            int y = operators[i].y;
            int cur = (m+10) * x + y + 1;
            ilands[i] = cur;
            nums[i] = i;
            for (int[] around : arounds) {
                int a = x + around[0];
                int b = y + around[1];
                if (a < 0 || a > n || b < 0 || b > m) continue;
                int value = (m+10)  * a + b + 1;
                for (int j = 0; j <i; j++) {
                    if (value == ilands[j]) {
                        if (i != nums[j]) {
                            int change = nums[j];
                            num--;
                            for (int k = 0; k < i; k++) {
                                if (nums[k] == change) nums[k] = i;
                            }
                        }
                    }
                }
            }
            res.add(num);
        }

        return res;
    }
}
