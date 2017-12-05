package com.stark._601_700._671_680;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stark on 2017/12/5.
 */
public class LintCode_680 {

    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add(new ArrayList<>());
            return res;
        }
        if (s.length() == 1) {
            List<String> list = new ArrayList<>();
            list.add(s);
            res.add(list);
        }
        if (s.length() == 2) {
            List<String> list1 = new ArrayList<>();
            list1.add(s);
            res.add(list1);
            List<String> list2 = new ArrayList<>();
            list2.add(s.substring(0, 1));
            list2.add(s.substring(1, 2));
            res.add(list2);
        }
        if (s.length() >= 3) {
            String s1 = s.substring(0, 1);
            String n1 = s.substring(1, s.length());
            List<List<String>> lists1 = splitString(n1);
            for (List<String> list : lists1) {
                list.add(0, s1);
            }
            res.addAll(lists1);
            String s2 = s.substring(0, 2);
            String n2 = s.substring(2, s.length());
            List<List<String>> lists2 = splitString(n2);
            for (List<String> list : lists2) {
                list.add(0, s2);
            }
            res.addAll(lists2);
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_680 test = new LintCode_680();
        List<List<String>> lists = test.splitString("2222");
        System.out.println(lists);
    }
}
