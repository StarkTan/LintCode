package com.stark._101_200._161_170;

import java.util.*;

/**
 * 汉诺塔问题
 */
public class LintCode_169 {
    private Map<Integer, String> hanlder = new HashMap<>();

    public LintCode_169() {
        hanlder.put(-3, "from A to C");
        hanlder.put(3, "from C to A");
        hanlder.put(-1, "from A to B");
        hanlder.put(1, "from B to A");
        hanlder.put(-2, "from B to C");
        hanlder.put(2, "from C to B");
    }

    public List<String> towerOfHanoi(int n) {
        // write your code here
        //使用D替换，方便确认差值
        return solve('A', 'D', 'B', n);
    }
    //以最大的移动为坐标，将问题分成移动前的处理和移动后的处理
    private List<String> solve(char from, char to, char wait, int n) {
        List<String> res = new ArrayList<>();
        if (n > 1) {
            res.addAll(solve(from, wait, to, n - 1));
            res.add(hanlder.get(from - to));
            res.addAll(solve(wait, to, from, n - 1));
        } else {
            res.add(hanlder.get(from - to));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_169().towerOfHanoi(3));
    }
}
