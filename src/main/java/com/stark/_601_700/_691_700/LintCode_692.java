package com.stark._601_700._691_700;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Stark on 2017/10/9.
 * Given an array and a window size that is sliding along the array,
 * find the sum of the count of unique elements in each window.
 */
public class LintCode_692 {

    public int slidingWindowUniqueElementsSum(int[] nums, int k) {
        // write your code here
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len && i < k; i++) {
            int in = nums[i];
            if (map.containsKey(in)) {
                map.put(in, map.get(in) + 1);
            } else {
                map.put(in, 1);
            }
        }
        res += getNum(map);
        for (int i = 1; i <= len - k; i++) {
            int out = nums[i - 1];
            int in = nums[i + k - 1];
            if (map.containsKey(in)) {
                map.put(in, map.get(in) + 1);
            } else {
                map.put(in, 1);
            }
            map.put(out, map.get(out) - 1);
            res += getNum(map);
        }
        return res;
    }

    private int getNum(Map<Integer, Integer> map) {
        int res = 0;
        Set<Map.Entry<Integer, Integer>> integers = map.entrySet();
        for (Map.Entry<Integer, Integer> next : integers) {
            if (next.getValue() == 1) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_692 test = new LintCode_692();
        System.out.println(test.slidingWindowUniqueElementsSum(new int[]{1, 2, 1, 3, 3}, 6));
    }

}
