package com.stark._401_500._421_430;

/**
 * Created by Stark on 2017/10/8.
 * 求逆波兰表达式的值。
 * 在逆波兰表达法中，其有效的运算符号包括 +, -, *, / 。
 * 每个运算对象可以是整数，也可以是另一个逆波兰计数表达
 */
public class LintCode_424 {
    public int evalRPN(String[] tokens) {
        // write your code here
        int one = -1;
        int two = -1;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (null == s) continue;
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int first = Integer.valueOf(tokens[one]);
                int second = Integer.valueOf(tokens[two]);
                tokens[two] = null;
                tokens[one] = null;
                if (s.equals("*")) {
                    tokens[i] = first * second + "";
                }
                if (s.equals("/")) {
                    tokens[i] = first / second + "";
                }
                if (s.equals("-")) {
                    tokens[i] = first - second + "";
                }
                if (s.equals("+")) {
                    tokens[i] = first + second + "";
                }
                //递归超时
                // return evalRPN(tokens);
                one = -1;
                two = -1;
                i = -1;
                continue;
            }
            if (one == -1) {
                one = i;
            } else if (two == -1) {
                two = i;
            } else {
                one = two;
                two = i;
            }
        }
        return Integer.parseInt(tokens[one]);
    }

    public static void main(String[] args) {
        LintCode_424 test = new LintCode_424();
        int i = test.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(i);
    }
}
