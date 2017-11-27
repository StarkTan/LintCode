package com.stark._401_500._411_420;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/11/27.
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个二进制的差异。
 * <p>
 * 给定一个非负整数 n ，表示该代码中所有二进制的总数，请找出其格雷编码顺序。
 */
public class LintCode_411 {

    public List<Integer> grayCode(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n == 0) return res;
        res.add(1);
        for (int i = 2; i <= n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) + 1 << (i - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1<<2);
    }
}
