package com.stark._101_200._151_160;

import com.stark._1_100._11_20.LintCode_13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/11/28.
 */
public class LintCode_152 {

    /**
     * 不是字典序
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) return res;
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                res.add(list);
            }
        } else {
            for (int i = 1; i <= n; i++) {
                List<List<Integer>> combine = combine(i - 1, k - 1);
                for (List<Integer> list : combine) {
                    list.add(i);
                }
                res.addAll(combine);
            }
        }
        return res;
    }

    //字典序版本
    public List<List<Integer>> combine_V1(int n, int k) {
        // write your code here
        return solve(1, n, k);
    }

    private List<List<Integer>> solve(int begin, int end, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (begin > end) return res;
        if (k == 1) {
            for (int i = begin; i <= end; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                res.add(list);
            }
        } else {
            for (int i = begin; i <= end; i++) {
                List<List<Integer>> solve = solve(i + 1, end, k - 1);
                for (List<Integer> list : solve) {
                    list.add(0, i);
                }
                res.addAll(solve);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> combine = new LintCode_152().combine_V1(4, 2);
        System.out.println(combine);
    }
}
