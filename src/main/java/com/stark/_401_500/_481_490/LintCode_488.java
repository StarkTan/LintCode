package com.stark._401_500._481_490;

import com.stark.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/12/4.
 * 写一个算法来判断一个数是不是"快乐数"。
 * <p>
 * 一个数是不是快乐是这么定义的：对于一个正整数，每一次将该数替换为他每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为1，或是无限循环但始终变不到1。如果可以变为1，那么这个数就是快乐数。
 */
public class LintCode_488 {
    public boolean isHappy(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while (n != 1) {
            String str = n + "";
            int next = 0;
            for (int i = 0; i < str.length(); i++) {
                int cur = str.charAt(i) - '0';
                next += cur * cur;
            }
            System.out.println(next);
            if (list.contains(next)) return false;
            else list.add(next);
            n = next;
        }
        return true;
    }

    public static void main(String[] args) {
        LintCode_488 lintCode_488 = new LintCode_488();
        boolean happy = lintCode_488.isHappy(19);
        System.out.println(happy);
    }
}
