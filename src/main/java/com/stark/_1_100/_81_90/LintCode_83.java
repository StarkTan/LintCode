package com.stark._1_100._81_90;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Stark on 2017/10/20.
 * 给出3*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 */
public class LintCode_83 {
    public int singleNumberII(int[] A) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if (map.containsKey(i)) {
                Integer integer = map.get(i);
                if (integer > 1) {
                    map.remove(i);
                } else {
                    map.put(i, integer + 1);
                }
            } else {
                map.put(i, 1);
            }
        }
        if (map.isEmpty()) {
            return 0;
        }
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        return iterator.next();
    }
}
