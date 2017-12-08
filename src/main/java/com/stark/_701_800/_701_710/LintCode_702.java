package com.stark._701_800._701_710;

/**
 * Created by Stark on 2017/12/6.
 */
public class LintCode_702 {

    public String concatenetedString(String s1, String s2) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return sb.append(s1).append(s2).toString();
        }
        int pos = 0;
        while (pos < s2.length()) {
            String sub = s2.substring(pos, pos + 1);
            if (s1.contains(sub)) {
                s1 = s1.replace(sub, "");
                s2 = s2.replace(sub, "");
            } else {
                pos++;
            }
        }
        return sb.append(s1).append(s2).toString();
    }
}
