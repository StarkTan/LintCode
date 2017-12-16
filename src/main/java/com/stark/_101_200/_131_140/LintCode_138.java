package com.stark._101_200._131_140;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_138 {
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = nums[i];
            if (count == 0) {
                res.add(i);
                res.add(i);
                return res;
            }
            for (int j = i + 1; j < nums.length; j++) {
                count += nums[j];
                if (count == 0) {
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_138().subarraySum(new int[]{-3, 1, 2, -3, 3}));
    }
}
