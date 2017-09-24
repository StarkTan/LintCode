package com.stark._601_700._651_660;

import java.util.*;

/**
 * Created by Stark on 2017/9/20.
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
public class LintCode_657 {
    List<Integer> list;
    int num;
    Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public LintCode_657() {
        list = new ArrayList<>();
        num = 0;
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(num, val);
            map.put(val, num++);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else if (num == 0) {
            map.remove(val);
            return true;
        } else {
            int removedIndex = map.get(val);
            int backElement = list.get(num - 1);
            if (backElement == val) {
                map.remove(val);
                list.remove(num - 1);
                num--;
                return true;
            }
            map.put(backElement, removedIndex);
            list.set(removedIndex, backElement);
            num--;
            map.remove(val);
            return true;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random rdm = new Random();
        return list.get(rdm.nextInt(num));
    }
}
