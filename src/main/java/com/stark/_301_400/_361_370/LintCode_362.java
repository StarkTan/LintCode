package com.stark._301_400._361_370;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Stark on 2017/12/1.
 * 给出一个可能包含重复的整数数组，和一个大小为 k 的滑动窗口, 从左到右在数组中滑动这个窗口，找到数组中每个窗口内的最大值。
 */
public class LintCode_362 {
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>(); //双端队列
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!deque.isEmpty() && deque.peekLast() < cur) {
                deque.pollLast();
            }
            deque.add(cur);
            if (i >= k - 1) {
                if (i >= k && nums[i - k - 1] == deque.peekFirst()) deque.pollFirst();
                res.add(deque.peekFirst());
            }
        }
        return res;
    }
}
