package com.stark._1_100._31_40;

import java.util.List;

/**
 * Created by Stark on 2017/9/14.
 * 给定一个旋转排序数组，在原地恢复其排序。
 */
public class LintCode_39 {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        if(null==nums) return;
        while (nums.get(0)>=nums.get(nums.size()-1)){
            nums.add(0,nums.remove(nums.size() - 1));
        }
    }
}
