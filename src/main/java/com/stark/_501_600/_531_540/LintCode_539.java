package com.stark._501_600._531_540;

/**
 * Created by Stark on 2017/9/17.
 * 给一个数组 nums 写一个函数将 0 移动到数组的最后面，非零元素保持原数组的顺序
 * 1.必须在原数组上操作
 * 2.最小化操作数
 */
public class LintCode_539 {
    public void moveZeroes(int[] nums) {
        int pos = -1; //首位0所在位置
        for (int i = 0; i < nums.length; i++) {
            if (pos < 0 && nums[i] != 0) continue;
            if (pos < 0 && nums[i] == 0) {
                pos = i;
                continue;
            }
            if (pos >= 0 && nums[i] != 0) {
                nums[pos] = nums[i];
                nums[i] = 0;
                pos++;
            }
        }
    }
}
