package com.stark._101_200._131_140;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/12/5.
 */
public class LintCode_133 {

    public List<String> longestWords(String[] dictionary) {
        // write your code here
        List<String> res = new ArrayList<>();
        int curlen = 0;
        for (String str : dictionary) {
            if (res.isEmpty()) {
                res.add(str);
                curlen = str.length();
                continue;
            }
            if (str.length() > curlen) {
                res.clear();
                res.add(str);
                curlen = str.length();
                continue;
            }
            if (str.length() == curlen) res.add(str);
        }

        return res;
    }
}
