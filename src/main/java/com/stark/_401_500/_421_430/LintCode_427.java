package com.stark._401_500._421_430;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/11/2.
 * 给定 n 对括号，请写一个函数以将其生成新的括号组合，并返回所有组合结果
 * TODO
 */
public class LintCode_427 {
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        solve(n, n, "", res);
        return res;
    }

    private void solve(int left, int right, String s, List<String> res) {
        if (left <= 0 && right <= 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            solve(left - 1, right, s + "(", res);
        }
        if (right > 0 && right > left) {
            solve(left, right - 1, s + ")", res);
        }
    }

    public static void main(String[] args) {
        System.out.println('(' - ')');
    }
}
