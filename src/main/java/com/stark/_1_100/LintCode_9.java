package com.stark._1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/9/2.
 * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
 * 如果这个数被3整除，打印fizz.
 * 如果这个数被5整除，打印buzz.
 * 如果这个数能同时被3和5整除，打印fizz buzz.
 */
public class LintCode_9 {
    public List<String> fizzBuzz(int n) {
        // write your code here
        ArrayList<String> results = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                results.add("fizz buzz");
            } else if (i % 5 == 0) {
                results.add("buzz");
            } else if (i % 3 == 0) {
                results.add("fizz");
            } else {
                results.add(String.valueOf(i));
            }
        }
        return results;
    }
}
