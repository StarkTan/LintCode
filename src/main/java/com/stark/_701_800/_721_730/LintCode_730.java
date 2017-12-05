package com.stark._701_800._721_730;

import java.util.HashMap;

/**
 * Created by Stark on 2017/12/4.
 * 给一整数 n, 我们需要求前n个自然数形成的集合的所有可能子集中所有元素的和。
 * TODO 超时
 */
public class LintCode_730 {
    public int subSum(int n) {
        // write your code here
        long total = (1 << n) - 1;
        int res = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (long i = 1; i <= total; i++) {
            long cur = i;
            int count = 0;
            while (cur != 0) {
                if (map.containsKey(cur)) {
                    count += map.get(cur);
                    break;
                }
                String str = Long.toBinaryString(cur);
                int length = str.length();
                count += length;
                cur -= 1 << length - 1;
            }
            map.put(i, count);
            res += count;
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_730 lintCode_730 = new LintCode_730();
        int i = lintCode_730.subSum(27);
        System.out.println(i);
    }
}
