package com.stark._401_500._431_440;

/**
 * Created by Stark on 2017/10/8.
 * 给出一个数组A包含n个元素，表示n本书以及各自的页数。现在有个k个人复印书籍，每个人只能复印连续一段编号的书，比如A[1],A[2]由第一个人复印，
 * 但是不能A[1],A[3]由第一个人复印，求最少需要的时间复印所有书。
 */
public class LintCode_437 {
    public int copyBooks(int[] pages, int k) {
        // write your code here
        //寻找极值
        int end = 0;
        int begin = 0;
        for (int i : pages) {
            end += i;
            begin = Math.max(begin, i);
        }
        while (begin < end) {
            int mid = begin / 2 + end / 2;
            if (begin % 2 == 1 && end % 2 == 1) mid++;
            int cur = 1;
            int curNum = 0;
            for (int i : pages) {
                if (curNum == 0) {
                    curNum = i;
                    if (curNum > mid) {
                        curNum = 0;
                        cur++;
                    }
                } else {
                    curNum = curNum + i;
                    if (curNum > mid) {
                        curNum = i;
                        cur++;
                    }
                }
            }
            if (cur > k) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
