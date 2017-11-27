package com.stark._401_500._421_430;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/11/27.
 * 给一个由数字组成的字符串。求出其可能恢复为的所有IP地址。
 */
public class LintCode_426 {
    public List<String> restoreIpAddresses(String s) {
        // write your code here
        return solve(s, 4);
    }

    private List<String> solve(String s, int time) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (time == 1) {
            if (!(len > 1 && s.startsWith("0")) && Integer.parseInt(s) <= 255) res.add(s);
        } else {
            for (int i = 1; i <= len - time + 1 && i <= 3; i++) {
                String cur = s.substring(0, i);
                if ((cur.length() > 1 && cur.startsWith("0")) || Integer.parseInt(cur) > 255) break;
                String next = s.substring(i, len);
                List<String> solve = solve(next, time - 1);
                for (String str : solve) {
                    res.add(cur + '.' + str);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_426 test = new LintCode_426();
        List<String> list = test.restoreIpAddresses("010010");
        System.out.println(list);
    }
}
