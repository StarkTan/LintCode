package com.stark._301_400._361_370;

/**
 * Created by Stark on 2017/10/10.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class LintCode_363 {
    public int trapRainWater(int[] heights) {
        // write your code here
        int res = 0;
        int len = heights.length;
        if (len == 0) return res;
        int lmax = 0;
        int rmax = 0;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            lmax = Math.max(lmax, heights[l]);
            rmax = Math.max(rmax, heights[r]);
            if (lmax < rmax) {
                res += lmax - heights[l];
                l++;
            } else {
                res += rmax - heights[r];
                r--;
            }
        }
        return res;
        /*
        int ret = 0;
        if(heights.size()==0)
            return ret;
        int lmax = 0, rmax = 0;
        int l = 0, r = heights.size()-1;
        while(l<r)
        {
            lmax = max(lmax,heights[l]);
            rmax = max(rmax,heights[r]);
            if(lmax<rmax)
                ret += lmax-heights[l],l++;
            else
                ret += rmax-heights[r],r--;
        }
        return ret;
         */
    }
}
