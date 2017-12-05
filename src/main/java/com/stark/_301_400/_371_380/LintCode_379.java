package com.stark._301_400._371_380;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Stark on 2017/12/5.
 */
public class LintCode_379 {

    public String minNumber(int[] nums) {
        // write your code here
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int curi = nums[i];
                int curj = nums[j];
                if (!solve(curi, curj)) {
                    nums[i] = curj;
                    nums[j] = curi;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            if (num == 0) continue;
            sb.append(num);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }

    private boolean solve(int curi, int curj) {
        String str1 = curi + "" + curj;
        String str2 = curj + "" + curi;
        int len = str1.length();
        for (int i = 0; i < len; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 > c2) return false;
            if (c2 > c1) return true;
        }
        return false;
    }
}
