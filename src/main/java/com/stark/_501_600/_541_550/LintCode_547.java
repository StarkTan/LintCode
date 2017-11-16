package com.stark._501_600._541_550;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Stark on 2017/10/30.
 * 返回两个数组的交
 */
public class LintCode_547 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> res = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }
        int[] ress = new int[res.size()];
        int pos = 0;
        for (int i : res) {
            ress[pos++] = i;
        }
        return ress;
    }
}
