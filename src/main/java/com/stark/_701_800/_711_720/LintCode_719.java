package com.stark._701_800._711_720;

/**
 * Created by Stark on 2017/10/20.
 * 给一个字符串类型的数字, 写一个方法去找到最大值, 你可以在任意两个数字间加 + 或 *
 * 按顺序操作
 */
public class LintCode_719 {
    public int calcMaxValue(String str) {
        // write your code here
        if (str == null) return 0;
        int res = 0;
        char[] chars = str.toCharArray();
        int begin = 0;
        for (; begin < chars.length; begin++) {
            if (chars[begin] != '0') {
                if (res == 0) {
                    res = chars[begin] - '0';
                } else if (res == 1) {
                    res = res + (chars[begin] - '0');
                } else {
                    break;
                }
            }
        }
        for (int i = begin; i < chars.length; i++) {
            switch (chars[i]) {
                case '0':
                    break;
                case '1':
                    res++;
                    break;
                default:
                    res = res * (chars[i] - '0');
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_719 test = new LintCode_719();
        int i = test.calcMaxValue("011791");
        System.out.println(i);
    }
}
