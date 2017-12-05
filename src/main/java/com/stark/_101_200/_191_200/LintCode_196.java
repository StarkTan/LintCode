package com.stark._101_200._191_200;

/**
 * Created by Stark on 2017/12/5.
 */
public class LintCode_196 {

    public int findMissing(int[] nums) {
        // write your code here
        int len = nums.length;
        int pos = len;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            if (cur == len) {
                pos = i;
                continue;
            }
            if (nums[cur] != cur) {
                if (pos < len && cur == nums[pos]) pos = i;
                nums[i] = nums[cur];
                nums[cur] = cur;
                i--;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        LintCode_196 test = new LintCode_196();
        test.findMissing(new int[]{9, 8, 7, 6, 2, 0, 1, 5, 4});
    }
}
