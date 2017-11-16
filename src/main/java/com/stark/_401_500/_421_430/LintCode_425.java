package com.stark._401_500._421_430;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/28.
 */
public class LintCode_425 {
    public List<String> letterCombinations(String digits) {
        // write your code here
        //建立映射
        String[] map = {" ", null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits==null||digits.contains("1")||digits.isEmpty()) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            int num = digits.charAt(i) - '0';
            String s = map[num];
            for (int j = 0; j < s.length(); j++) {
                for (String str : res) {
                    temp.add(str + s.charAt(j));
                }
            }
            res.clear();
            res.addAll(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_425 test = new LintCode_425();
        List<String> list = test.letterCombinations("2034");
        System.out.println(list);
    }
}
