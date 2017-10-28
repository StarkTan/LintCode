package com.stark._101_200._181_190;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SplittableRandom;

/**
 * Created by Stark on 2017/10/26.
 * 给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数。
 */
public class LintCode_184 {
    public String largestNumber(int[] nums) {
        // write your code here
        int len = nums.length;
        fastSort(nums, 0, len - 1);
        StringBuilder res = new StringBuilder();
        for (int i : nums) {
            if (res.length() == 0 && i == 0) {
                continue;
            }
            res.append(i);
        }
        return res.toString();
    }

    private void fastSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int var = nums[begin];
        int pos = begin;
        int left = end;
        while (left > pos) {
            int cur = nums[left];
            if (solve(cur + "", var + "")) {
                left--;
            } else {
                nums[pos] = cur;
                nums[left] = nums[++pos];
            }
        }
        nums[pos] = var;
        fastSort(nums, begin, pos - 1);
        fastSort(nums, pos + 1, end);
    }

    private boolean solve(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        for (int i = 0; i < len1 && i < len2; i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return false;
            } else if (str1.charAt(i) < str2.charAt(i)) {
                return true;
            }
        }
        if (len1 > len2) {
            return solve(str1.substring(len2), str2);
        }
        return len1 < len2 && solve(str1, str2.substring(len1));
    }

    public static void main(String[] args) {
        LintCode_184 test = new LintCode_184();
        String s = test.largestNumber(new int[]{1, 20, 23, 4, 8});
        System.out.println(s);
    }
}
