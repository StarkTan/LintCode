package com.stark._301_400._361_370;

/**
 * Created by Stark on 2017/10/18.
 * 给一个用字符串表示的表达式数组，求出这个表达式的值。
 * 注意事项
 * 表达式只包含整数, +, -, *, /, (, ).
 */
public class LintCode_368 {
    public int evaluateExpression(String[] expression) {
        // write your code here
        int len = expression.length;
        if (len == 0) return 0;
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
        if (end < 0) {
            return 0;
        }
        return solve(begin, end, properties, newExpression);
    }

    private int solve(int begin, int end, int[] properties, String[] newExpression) {
        if (end == begin) {
            return Integer.valueOf(newExpression[end]);
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
        int left = solve(begin, pos - 1, properties, newExpression);
        int right = solve(pos + 1, end, properties, newExpression);
        String s = newExpression[pos];
        int res = 0;
        switch (s) {
            case "-":
                res = left - right;
                break;
            case "+":
                res = left + right;
                break;
            case "/":
                res = left / right;
                break;
            case "*":
                res = left * right;
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_368 lintCode_368 = new LintCode_368();
        int i = lintCode_368.evaluateExpression(new String[]{"(", "999", "/", "3", "/", "3", "/", "3", ")",
                "+", "(", "1", "+", "9", "/", "3", ")"});
        System.out.println(i);
    }


}
