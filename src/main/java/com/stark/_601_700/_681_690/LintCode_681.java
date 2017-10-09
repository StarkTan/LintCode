package com.stark._601_700._681_690;

/**
 * Created by Stark on 2017/10/9.
 * Given a list of integers and find the smallest prime number that doesn't appear in this list.
 */
public class LintCode_681 {
    public int firstMissingPrime(int[] nums) {
        // write your code here
        int len = nums.length;
        if (len < 2) return 2;
        int all = nums[nums.length - 1];
        if (nums[0] != 2) return 2;
        int pos = 1;
        a:
        for (int i = 3; i <= all; i++) {
            b:
            for (int j = 0; j < pos; j++) {
                if (i % nums[j] == 0) {
                    continue a;
                }
            }
            if (nums[pos] != i) {
                return i;
            } else {
                pos++;
            }
        }
        //寻找下一个质数
        int next = all + 1;
        c:
        while (true) {
            for (int num : nums) {
                if (next % num == 0) {
                    next++;
                    continue c;
                }
            }
            return next;
        }
    }
}
