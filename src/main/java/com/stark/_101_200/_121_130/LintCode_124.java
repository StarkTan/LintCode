package com.stark._101_200._121_130;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_124 {

    public int longestConsecutive(int[] num) {
        // write your code here
        //用来保存数和以他开头的序列长度
        Map<Integer, Integer> map = new HashMap<>();
        //用来保存已经进行验证过的序列长度
        Set<Integer> set = new HashSet<>();
        for (int n : num) map.put(n, 1);
        int max = 0;
        for (int n : num) {
            if (set.contains(n)) continue;
            int cur = 1;
            int next = n - 1;
            while (map.containsKey(next)) {
                if (set.contains(next)) {
                    cur += map.get(next);
                    break;
                } else {
                    cur++;
                    map.remove(next);
                    next--;
                }
            }
            map.put(n, cur);
            max = Math.max(cur, max);
            set.add(n);
        }
        return max;
    }

    public static void main(String[] args) {
        LintCode_124 test = new LintCode_124();
        int i = test.longestConsecutive(new int[]{1, 1});
        System.out.println(i);
    }
}
