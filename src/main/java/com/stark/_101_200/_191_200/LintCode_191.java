package com.stark._101_200._191_200;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_191 {
    public int maxProduct(int[] nums) {
        // write your code here
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        return solve(0, nums);
    }

    private int solve(int start, int[] nums) {

        while (start < nums.length && nums[start] == 0) start++;
        if (start >= nums.length) return 0;
        int cur = start;
        int total = 1;
        for (; cur < nums.length; cur++) {
            if (nums[cur] == 0) break;
            total *= nums[cur];
        }
        int nextStart = cur + 1;
        cur--;
        if (total < 0) {
            int max_left = total;
            for (; start <= cur; cur--) {
                max_left /= nums[cur];
                if (nums[cur] < 0) break;
            }
            int max_right = total;
            for (; start <= cur; start++) {
                max_right /= nums[start];
                if (nums[start] < 0) break;
            }
            total = Math.max(max_left, max_right);
        }
        return Math.max(total, solve(nextStart, nums));
    }

    public static void main(String[] args) {
        int i = new LintCode_191().maxProduct(new int[]{-1, 99});
        System.out.println(i);
    }
}
