package com.stark._501_600._571_580;

/**
 * Created by Stark on 2017/12/8.
 * TODO
 */
public class LintCode_575 {

    public String expressionExpand(String s) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        if (!s.contains("[")) {
            sb.append(s);
            return sb.toString();
        }

        return "";
    }
}
