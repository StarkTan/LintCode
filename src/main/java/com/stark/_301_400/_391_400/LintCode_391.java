package com.stark._301_400._391_400;

import com.stark.entity.Interval;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_391 {

    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        PriorityQueue<Integer> off = new PriorityQueue<>();
        PriorityQueue<Integer> down = new PriorityQueue<>();
        for (Interval val : airplanes) {
            off.add(val.start);
            down.add(val.end);
        }
        int max = 0;
        int res = 0;
        while (!off.isEmpty()) {
            int take_off = off.poll();
            while (down.peek() <= take_off) {
                res--;
                down.poll();
            }
            res++;
            max = Math.max(max, res);
        }
        return max;
    }
}
