package com.stark._1_100._81_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/10/10.
 * Your title here...Given n unique integers, number k (1<=k<=n) and target.
 */
public class LintCode_90 {
    public List<List<Integer>> kSumII(int[] A, int k, int targer) {
        // write your code here
        Arrays.sort(A);
        return solve(A,k,targer,0);
    }
    private List<List<Integer>> solve(int[] a, int k, int targer, int begin) {
        List<List<Integer>> lists =new ArrayList<>();
        if(k==1){
            for(int i=begin;i<=a.length-1;i++){
                if(a[i]==targer){
                    List<Integer> list = new ArrayList<>();
                    list.add(a[i]);
                    lists.add(list);
                }
                if(a[i]>targer){
                    break;
                }
            }
        }else if(k>1){
            for(int i=begin;i<a.length-1;i++){
                if(a[i]<targer){
                    List<List<Integer>> solve = solve(a, k - 1, targer - a[i], i + 1);
                    for(List<Integer> integers:solve){
                        integers.add(0,a[i]);
                    }
                    lists.addAll(solve);
                }else {
                    break;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        LintCode_90 test = new LintCode_90();
        List<List<Integer>> lists = test.kSumII(new int[]{0, 1, 2, 3, 4}, 3, 6);
        System.out.println(lists);
    }
}
