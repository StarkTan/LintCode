package com.stark._1101_1200._1161_1170;

import java.util.HashSet;
import java.util.Set;

public class LintCode_1163 {
    public int distributeCandies(int[] candies) {
        // write your code here
        int len = candies.length;
        if (len <= 0 || len % 2 == 1) return 0;
        Set<Integer> set = new HashSet<>();
        for (int candie : candies) {
            set.add(candie);
        }
        int typeNum = set.size();
        if (len / 2 > typeNum) return typeNum;
        else return len / 2;
    }
}
