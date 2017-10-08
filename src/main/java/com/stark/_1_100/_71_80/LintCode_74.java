package com.stark._1_100._71_80;

import com.stark.entity.SVNRepo;

/**
 * Created by Stark on 2017/10/8.
 * 代码库的版本号是从 1 到 n 的整数。某一天，有人提交了错误版本的代码，
 * 因此造成自身及之后版本的代码在单元测试中均出错。请找出第一个错误的版本号。
 */
public class LintCode_74 {
    public int findFirstBadVersion(int n) {
        // write your code here
        int begin = 0;
        int end = n;
        while (end > begin) {
            int mid = (begin / 2 + end / 2);
            if (begin % 2 == 1 && end % 2 == 1) {
                mid++;
            }
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }
}
