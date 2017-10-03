package com.stark._101_200._111_120;

/**
 * Created by Stark on 2017/10/3.
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class LintCode_117 {
    public int jump(int[] A) {
        // write your code here
        int result = 0;
        int len = A.length;
        int[] res = new int[len];
        res[0] = A[0];
        for (int i = 1; i < len; i++) {
            if (res[i - 1] >= i)
                res[i] = Math.max(A[i] + i, res[i - 1]);
            else
                res[i] = 0;
        }
        if(res[len - 1] < len-1){
            return result;
        }
        int tar = len - 1;

        while (tar > 0) {
            for (int i = 0; i < len - 1; i++){
                if(res[i]>=tar){
                    result++;
                    tar = i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LintCode_117 test = new LintCode_117();
        int jump = test.jump(new int[]{17, 8, 29, 17, 35, 28, 14, 2, 45, 8, 6, 54, 24, 43, 20, 14, 33, 31, 27, 11});
        System.out.println(jump);
    }
}
