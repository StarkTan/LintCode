package com.stark._101_200._151_160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/9/22.
 * 给出一组候选数字(C)和目标数字(T),找出C中所有的组合，使组合中数字的和为T。C中每个数字在每个组合中只能使用一次。
 * 注意事项
 * 所有的数字(包括目标数字)均为正整数。
 * 元素组合(a1, a2, … , ak)必须是非降序(ie, a1 ≤ a2 ≤ … ≤ ak)。
 * 解集不能包含重复的组合。
 */
public class LintCode_153 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        int end = num.length - 1;
        int begin = 0;
        return solve(num, begin, end, target);
    }

    private List<List<Integer>> solve(int[] nums, int begin, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            if (i != begin && nums[i] == nums[i - 1]) {
            } else {
                if (target > nums[i]) {
                    List<List<Integer>> lists = solve(nums, i + 1, end, target - nums[i]);
                    res.addAll(lists);
                    for (List<Integer> list : lists) {
                        list.add(0, nums[i]);
                    }
                } else if (target == nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_153 test = new LintCode_153();
        List<List<Integer>> lists = test.combinationSum2(new int[]{10, 1, 6, 7, 2, 1, 5}, 8);
        System.out.println(lists);
    }
}
