package com.stark._401_500._411_420;

/**
 * Created by Stark on 2017/10/27.
 * 给定一个字符串，验证其是否为数字。
 */
public class LintCode_417 {
    public boolean isNumber(String s) {
        // write your code here
        if (s == null) return false;
        s = s.trim();
        String[] es = s.split("e");
        if (es.length > 2 || es.length < 1) {
            return false;
        }
        //对第一组分析
        String s1 = es[0];
        if (s1.isEmpty()) return false;
        char[] chars1 = s1.toCharArray();
        int i = 0;
        if (chars1[0] == '-' || chars1[0] == '+') {
            i = 1;
            if (chars1.length == 1 || (chars1[1] == '.' && chars1.length == 2)) {
                return false;
            }
        } else {
            if (chars1[0] == '.' && chars1.length == 1) return false;
        }
        boolean getC = false;
        for (; i < chars1.length; i++) {
            char cur = chars1[i];
            if (cur == '.') {
                if (getC) return false;
                else getC = true;
                continue;
            }
            if (cur > '9' || cur < '0') return false;
        }
        if (es.length == 2) {
            s1 = es[1];
            if (s1.isEmpty()) return false;
            chars1 = s1.toCharArray();
            i = 0;
            if (chars1[0] == '-' || chars1[0] == '+') {
                i = 1;
                if (chars1.length == 1) {
                    return false;
                }
            }
            for (; i < chars1.length; i++) {
                char cur = chars1[i];
                if (cur > '9' || cur < '0') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LintCode_417 test = new LintCode_417();
        boolean number = test.isNumber(".1");
        System.out.println(number);
    }
}
