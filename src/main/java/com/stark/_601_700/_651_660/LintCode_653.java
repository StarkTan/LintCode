package com.stark._601_700._651_660;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/11/28.
 * 给定一个仅包含数字 0 - 9 的字符串和一个目标值，
 * 返回在数字之间添加了 二元 运算符(不是一元)+, - 或 * 之后所有能得到目标值的情况。
 */
public class LintCode_653 {
//    public List<String> addOperators(String num, int target) {
//        // write your code here
//        List<String> res = new ArrayList<>();
//        if (num == null || num.isEmpty()) return res;
//        if (Integer.parseInt(num) == target) res.add(num);
//        for (int i = 1; i <= num.length(); i++) {
//            Integer head = Integer.valueOf(num.substring(0, i));
//            String tail = num.substring(i, num.length());
//            if (target % head == 0) {
//                List<String> list = addOperators(tail, target / head);
//                for (String str : list) {
//                    res.add(head + "*" + str);
//                }
//            }
//            List<String> list = addOperators(tail, target - head);
//            for (String str : list) {
//                res.add(head + "+" + str);
//            }
//            list = addOperators(tail, target + head);
//            for (String str : list) {
//                res.add(head + "+" + str);
//            }
//        }
//        return res;
//    }


    List<String> res = new ArrayList<>();

    public List<String> addOperators(String num, int target) {

        dfs(num, target, "", 0, 0);
        return res;
    }

    private void dfs(String num, int target, String temp, long curResult, long preNum) {
        if (curResult == target && num.length() == 0) {
            res.add(temp);
            return;
        }

        for (int i = 1; i <= num.length(); i++) {
            String curStr = num.substring(0, i);

            if (curStr.length() > 1 && curStr.startsWith("0")) {
                return;
            }

            String newNum = num.substring(i);
            long curNum = Long.parseLong(curStr);

            if (temp.length() == 0) {
                dfs(newNum, target, curStr, curNum, curNum);
            } else {
                dfs(newNum, target, temp + "+" + curStr, curResult + curNum, curNum);
                dfs(newNum, target, temp + "-" + curStr, curResult - curNum, -curNum);
                //乘法的回溯
                dfs(newNum, target, temp + "*" + curStr, curResult - preNum + preNum * curNum, preNum * curNum);
            }
        }
    }


    public static void main(String[] args) {
        LintCode_653 test = new LintCode_653();
        System.out.println(test.addOperators("232", 8));
    }

}
