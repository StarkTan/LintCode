package com.stark._101_200._171_180;

import java.util.*;

/**
 * Created by Stark on 2017/11/28.
 * 给出一个字符串数组S，找到其中所有的乱序字符串(Anagram)。
 * 如果一个字符串是乱序字符串，那么他存在一个字母集合相同，但顺序不同的字符串也在S中。
 */
public class LintCode_171 {
    public List<String> anagrams(String[] strs) {
        // write your code here
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String string = null;
            if (str.isEmpty()) {
                string = str;
            } else {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                StringBuilder sb = new StringBuilder();
                char cur = chars[0];
                int count = 0;
                for (int i = 1; i < chars.length; i++) {
                    char c = chars[i];
                    if (c == cur) {
                        count++;
                    } else {
                        sb.append(count).append(cur);
                        cur = c;
                        count = 1;
                    }
                }
                sb.append(count).append(cur);
                string = sb.toString();
            }
            if (map.containsKey(string)) {
                map.get(string).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(string, list);
            }
        }
        List<String> res = new ArrayList<>();
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> value = entry.getValue();
            if (value.size() > 1) {
                res.addAll(value);
            }
        }
        return res;
    }
}
