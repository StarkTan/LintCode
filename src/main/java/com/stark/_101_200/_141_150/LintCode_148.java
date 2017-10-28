package com.stark._101_200._141_150;

import java.util.Arrays;

/**
 * Created by Stark on 2017/10/26.
 * 给定一个包含红，白，蓝且长度为 n 的数组，将数组元素进行分类使相同颜色的元素相邻，并按照红、白、蓝的顺序进行排序。
 * 我们可以使用整数 0，1 和 2 分别代表红，白，蓝。
 */
public class LintCode_148 {
    public void sortColors(int[] nums) {
        // write your code here
        boolean findOne = false;
        int two_begin = nums.length;
        int zero_end = -1;
        int pos = 0;
        while (pos < two_begin) {
            int cur = nums[pos];
            if (cur == 0) {
                if (findOne) {
                    nums[++zero_end] = 0;
                    nums[pos] = 1;
                } else {
                    zero_end++;
                    pos++;
                }
            } else if (cur == 1) {
                findOne = true;
                pos++;
            } else if (cur == 2) {
                two_begin--;
                while (nums[two_begin] == 2 && two_begin > pos) {
                    two_begin--;
                }
                nums[pos] = nums[two_begin];
                nums[two_begin] = 2;
            }
        }
    }

    public static void main(String[] args) {
        LintCode_148 test = new LintCode_148();
        int[] ints = {0, 1, 0, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2};
        test.sortColors(ints);
        System.out.println(Arrays.toString(ints));

    }
}
