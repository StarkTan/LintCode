package com.stark._301_400._361_370;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/18.
 * 给定一个表达式字符串数组，返回该表达式的逆波兰表达式（即去掉括号）。
 */
public class LintCode_370 {
    public List<String> convertToRPN(String[] expression) {
        // write your code here
        List<String> res = new ArrayList<>();
        int len = expression.length;
        int del = 0;
        for (String s : expression) {
            if (s.equals("(") || s.equals(")")) {
                del++;
            }
        }
        int[] properties = new int[len - del];
        String[] newExpression = new String[len - del];
        int level = 1000;
        int num = 0;
        int pos = 0;
        for (String s : expression) {
            switch (s) {
                case "(":
                    level *= 10;
                    break;
                case ")":
                    level /= 10;
                    break;
                case "-":
                case "+":
                    newExpression[pos] = s;
                    properties[pos++] = num-- + level;

                    break;
                case "/":
                case "*":
                    newExpression[pos] = s;
                    properties[pos++] = num-- + level + 500;
                    break;
                default:
                    newExpression[pos] = s;
                    properties[pos++] = Integer.MAX_VALUE;
                    break;
            }
        }
        int begin = 0;
        int end = properties.length - 1;
        solve(begin, end, properties, newExpression, res);
        return res;
    }

    private void solve(int begin, int end, int[] properties, String[] newExpression, List<String> res) {
        if (end == begin) {
            res.add(newExpression[end]);
            return;
        }
        if (end < begin) {
            return;
        }
        //找到最小值
        int min = Integer.MAX_VALUE;
        int pos = 0;
        for (int i = begin + 1; i < end; i++) {
            if (min > properties[i]) {
                pos = i;
                min = properties[i];
            }
        }
        solve(begin, pos - 1, properties, newExpression, res);
        solve(pos + 1, end, properties, newExpression, res);
        res.add(newExpression[pos]);
    }
}
