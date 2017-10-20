package com.stark._1_100._81_90;

import java.util.*;

/**
 * Created by Stark on 2017/10/20.
 * 给出2*n + 2 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 */
public class LintCode_84 {
    public List<Integer> singleNumberIII(int[] A) {
        List<Integer> res = new ArrayList<>();
        int total = -0;
        for (int i : A) {
            total = total ^ i;
        }
        //特殊处理 两个数或 为最小值
        if (total == Integer.MIN_VALUE) {
            int zero = 0;
            int one = 0;
            for (int i : A) {
                if (i > 0) {
                    zero = zero ^ i;
                } else {
                    one = one ^ i;
                }
            }
            res.add(zero);
            res.add(one);
            return res;
        }
        int div = 1;
        while (true) {
            if ((total / div) % 2 == 0) {
                div = div * 2;
            } else {
                break;
            }
        }
        int zero = 0;
        int one = 0;
        for (int i : A) {
            if ((i / div) % 2 == 0) {
                zero = zero ^ i;
            } else {
                one = one ^ i;
            }
        }
        res.add(zero);
        res.add(one);
        return res;
    }

    public static void main(String[] args) {
//        LintCode_84 lintCode_84 = new LintCode_84();
//        List<Integer> list = lintCode_84.singleNumberIII(new int[]{1, 5, -1, 1, 2, 2, 3, 4, 4, 5, 3, 2147483647, 8, 9, 9, 8});
//        System.out.println(list);
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(2147483646));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(2147483647 ^ -4);
    }
}
