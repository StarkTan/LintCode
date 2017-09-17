package com.stark._301_400._381_390;

/**
 * Created by Stark on 2017/9/17.
 * 请判定一个数独是否有效。
 * 该数独可能只填充了部分数字，其中缺少的数字用 . 表示。
 */
public class LintCode_389 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] nums = new int[9];
            for (int j = 0; j < 9; j++) {
                char c1 = board[i][j];
                if (c1 >= '0' && c1 <= '9') {
                    int num = c1 - '0';
                    if (nums[num - 1] != 0) {
                        return false;
                    } else {
                        nums[num - 1] = num;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            int[] nums = new int[9];
            for (int j = 0; j < 9; j++) {
                char c1 = board[j][i];
                if (c1 >= '0' && c1 <= '9') {
                    int num = c1 - '0';
                    if (nums[num - 1] != 0) {
                        return false;
                    } else {
                        nums[num - 1] = num;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = i * 3;
                int y = j * 3;

                int[] nums1 = new int[9];
                for (int h = x; h < x + 3; h++) {
                    for (int k = y; k < y + 3; k++) {

                        char c = board[h][k];
                        if (c >= '0' && c <= '9') {
                            int num = c - '0';
                            if (nums1[num - 1] != 0) {
                                return false;
                            } else {
                                nums1[num - 1] = num;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
