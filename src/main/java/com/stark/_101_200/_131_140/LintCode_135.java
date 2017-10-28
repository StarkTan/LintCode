package com.stark._101_200._131_140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/10/28.
 * 给出一组候选数字(C)和目标数字(T),找到C中所有的组合，
 * 使找出的数字和为T。C中的数字可以无限制重复被选取。
 */
public class LintCode_135 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length == 0) {
            lists.add(new ArrayList<>());
            return lists;
        }
        Arrays.sort(candidates);
        int begin = 0;
        int end = candidates.length - 1;
        return solve(candidates, begin, end, target);
    }

    private List<List<Integer>> solve(int[] candidates, int begin, int end, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int cur = candidates[i];
            if (cur > target) {
                break;
            } else if (cur == target) {
                List<Integer> list = new ArrayList<>();
                list.add(cur);
                lists.add(list);
            } else {
                List<List<Integer>> solve = solve(candidates, i, end, target - cur);
                for (List<Integer> list : solve) {
                    list.add(0, cur);
                }
                lists.addAll(solve);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        LintCode_135 test = new LintCode_135();
        List<List<Integer>> lists = test.combinationSum(new int[]{2, 3, 4, 5, 6, 7}, 7);
        System.out.println(lists);
    }
}
