package com.stark._701_800._731_740;

/**
 * Created by Stark on 2017/11/28.
 * Given an array of integers, replace every element with the next greatest
 * element (greatest element on the right side) in the array.
 * Since there is no element next to the last element, replace it with -1.
 * For example, if the array is [16, 17, 4, 3, 5, 2], then it should be modified to [17, 5, 5, 5, 2, -1].
 */
public class LintCode_735 {
    public void arrayReplaceWithGreatestFromRight(int[] nums) {
        // Write your code here.
        int begin = 0;
        int end = nums.length - 1;
        if (begin > end) return;
        int ans = nums[begin];
        while (begin <= end) {
            if (begin == end) {
                nums[begin] = -1;
                return;
            }
            if (nums[begin] == ans) {
                ans = Integer.MIN_VALUE;
                for (int i = begin + 1; i <= end; i++) {
                    ans = Math.max(ans, nums[i]);
                }
            }
            nums[begin++] = ans;
        }
    }

    //不要使用递归 数量大
    private void solve(int begin, int end, int[] nums, int ans) {
        if (begin == end) {
            nums[begin] = -1;
            return;
        }
        if (nums[begin] == ans) {
            ans = Integer.MIN_VALUE;
            for (int i = begin + 1; i <= end; i++) {
                ans = Math.max(ans, nums[i]);
            }
        }
        nums[begin] = ans;
        solve(begin + 1, end, nums, ans);
    }
}
