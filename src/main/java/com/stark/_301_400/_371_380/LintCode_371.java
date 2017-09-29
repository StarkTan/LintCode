package com.stark._301_400._371_380;

import java.util.ArrayList;

/**
 * Created by Stark on 2017/9/28.
 * 用递归的方法找到从1到最大的N位整数。
 * 递归的深度最多只有 N 层
 */
public class LintCode_371 {
    public ArrayList<Integer> numbersByRecursion(int n) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        int level = 1;
        for (int i = 1; i < n; i++) {
            level = level * 10;
        }
        if (n > 0) {
            ArrayList<Integer> newResult = new ArrayList<>();
            ArrayList<Integer> before = numbersByRecursion(n - 1);
            for (int i = 1; i <= 9; i++) {
                int begin = level * i;
                newResult.add(begin);
                for (int j : before) {
                    newResult.add(begin + j);
                }
            }
            result.addAll(before);
            result.addAll(newResult);
        }
        return result;
    }

    public static void main(String[] args) {
        LintCode_371 test = new LintCode_371();
        ArrayList<Integer> integers = test.numbersByRecursion(3);
        System.out.println(integers);
    }
}
