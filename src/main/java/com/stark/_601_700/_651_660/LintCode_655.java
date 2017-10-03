package com.stark._601_700._651_660;

/**
 * Created by Stark on 2017/10/3.
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 */
public class LintCode_655 {
    public String addStrings(String num1, String num2) {
        // write your code here
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        int len3 = (len1 > len2 ? len1 : len2) + 1;
        int[] nums = new int[len3];
        for (int i = 0; i < len3 - 1; i++) {
            int pos1 = len1 - i - 1;
            int pos2 = len2 - i - 1;
            int pos3 = len3 - i - 1;
            int num = 0;
            if (pos1 >= 0 && pos2 >= 0) {
                num = (chars1[pos1] - '0') + (chars2[pos2] - '0') + nums[pos3];
            } else if (pos1 >= 0) {
                num = (chars1[pos1] - '0') + nums[pos3];
            } else if (pos2 >= 0) {
                num = (chars2[pos2] - '0') + nums[pos3];
            }
            if (num >= 10) {
                nums[pos3] = num % 10;
                nums[pos3 - 1] = 1;
            } else {
                nums[pos3] = num;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
            if (i == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(i);
        }
        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
