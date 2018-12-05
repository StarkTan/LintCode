package com.stark._1201_1300._1290_1300;

import java.util.*;

public class LintCode_1297 {

    public List<Integer> countSmaller(int[] nums) {
        // write your code here
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if (len == 0) return res;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Integer[] integers = set.toArray(new Integer[]{});
        Arrays.sort(integers);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < integers.length; i++) {
            map.put(integers[i], i);
        }
        int[] arr_map = new int[integers.length];
        for (int i = 0; i < len; i++) {
            int count = 0;
            int cur = nums[len - 1 - i];
            int cur_map = map.get(cur);
            arr_map[cur_map]++;
            for (int j = 0; j < cur_map; j++) {
                count += arr_map[j];
            }
            res.addFirst(count);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_1297().countSmaller(new int[]{7, 6, 6, 6, 1}));
    }
}
