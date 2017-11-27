package com.stark._401_500._411_420;

/**
 * Created by Stark on 2017/11/27.
 */
public class LintCode_420 {

    public String countAndSay(int n) {
        // write your code here
        String res = "1";
        for (int i = 2; i <= n; i++) {
            char[] chars = res.toCharArray();
            StringBuilder sb = new StringBuilder();
            int len = chars.length;
            char cur = chars[0];
            int count = 1;
            for (int j = 1; j < len; j++) {
                if (chars[j] == cur) {
                    count++;
                } else {
                    sb.append(count).append(cur);
                    count = 1;
                    cur = chars[j];
                }
            }
            sb.append(count).append(cur);
            res = sb.toString();
        }
        return res;
    }
}
