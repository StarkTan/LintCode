package com.stark._501_600._521_530;

/**
 * Created by Stark on 2017/11/28.
 * 实现一个leftpad库，如果不知道什么是leftpad可以看样例
 */
public class LintCode_524 {
    static public String leftPad(String originalStr, int size) {
        // Write your code here
        return leftPad(originalStr, size, ' ');
    }

    /*
     * @param originalStr: the string we want to append to
     * @param size: the target length of the string
     * @param padChar: the character to pad to the left side of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); i++) {
            sb.append(padChar);
        }
        sb.append(originalStr);
        return sb.toString();
    }
}
