package com.stark._601_700._621_630;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Stark on 2017/12/6.
 */
public class LintCode_622 {

    public boolean canCross(int[] stones) {
        // write your code here
        int len = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++)
            map.put(i, new HashSet<>());
        map.get(0).add(1);
        for (int i = 1; i < len; i++) {
            int cur = stones[i];
            Set<Integer> curSet = map.get(i);
            for (int j = i - 1; j >= 0; j--) {
                int bef = stones[j];
                int length = cur-bef;
                if (map.get(j).contains(length)) {
                    curSet.add(length);
                    curSet.add(length + 1);
                    curSet.add(length - 1);
                }
            }
            if (curSet.isEmpty()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = new LintCode_622().canCross(new int[]{0,1,3,5,6,8,12,17});
        System.out.println(b);
    }

}
