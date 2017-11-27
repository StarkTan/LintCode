package com.stark._401_500._451_460;

/**
 * Created by Stark on 2017/11/24.
 * 在一个排序数组中找一个数，返回该数出现的任意位置，如果不存在，返回-1
 */
public class LintCode_457 {
    public int findPosition(int[] nums, int target) {
        // write your code here
        int begin = 0;
        int end = nums.length;
        int res = -1;
        while (begin < end) {
            int mid = begin / 2 + end / 2;
            if (begin % 2 == 1 && end % 2 == 1) mid++;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid - 1;
            else begin = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_457 lintCode_457 = new LintCode_457();
        int position = lintCode_457.findPosition(new int[]{1,2,2,4,5,5}, 2);
        System.out.println(position);
    }
}
