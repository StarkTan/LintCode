package com.stark._601_700._631_640;

/**
 * Created by Stark on 2017/10/27.
 * 给出一个数组 nums 包含 n + 1 个整数，每个整数是从 1 到 n (包括边界)，
 * 保证至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 1.不能修改数组(假设数组只能读)
 * 2.只能用额外的O(1)的空间
 * 3.时间复杂度小于O(n^2)
 * 4.数组中只有一个重复的数，但可能重复超过一次
 */
public class LintCode_633 {
    public int findDuplicate(int[] nums) {
        // write your code here
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        int res = 0;
        while (true) {
            res = nums[res];
            slow = nums[slow];
            if (res == slow) break;
        }
        return res;
    }
}
