package com.stark._501_600._541_550;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_548 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> A = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                A.add(nums1[i]);
                i++;
                j++;

            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }

        }
        int[] res = new int[A.size()];
        for (i = 0; i < A.size(); i++) {
            res[i] = (int) A.get(i);
        }
        return res;
    }
}
