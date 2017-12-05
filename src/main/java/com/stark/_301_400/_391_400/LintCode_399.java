package com.stark._301_400._391_400;

import com.stark.entity.NBCompare;

/**
 * Created by Stark on 2017/12/5.
 * 使用快排提交失败
 */
public class LintCode_399 {
    /*public void sortNutsAndBolts(String[] nuts, String[] bolts, NBCompare compare) {
        // write your code here
        int begin = 0;
        int end = nuts.length - 1;
        solve1(nuts, bolts, begin, end, compare);

    }

    private void solve1(String[] nuts, String[] bolts, int begin, int end, NBCompare compare) {
        if (begin >= end) return;
        String nut = nuts[begin];
        int pos = solve2(nut, bolts, begin, end, compare);
        String bolt = bolts[pos];
        solve2(bolt, nuts, begin, end, compare);
        solve1(nuts, bolts, begin, pos - 1, compare);
        solve1(nuts, bolts, pos + 1, end, compare);
    }

    private int solve2(String str, String[] strs, int begin, int end, NBCompare compare) {
        int sim = 0;
        while (begin < end) {
            String cur = strs[begin];
            int cmp = compare.cmp(str, cur);
            if (cmp == -1) {
                strs[begin] = strs[end];
                strs[end] = cur;
                end--;
            } else if (cmp == 1) {
                begin++;
            } else {
                if (compare.cmp(strs[begin + 1 + sim], cur) == 0) sim++;
                strs[begin] = strs[begin + 1 + sim];
                strs[begin + 1] = cur;
            }
        }
        return begin;
    }*/

    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBCompare compare) {
        // write your code here
        for(int i = 0;i<nuts.length;i++){
            for(int j = i;j<bolts.length;j++){
                int record = compare.cmp(nuts[i] , bolts[j]);
                if(record == 0){
                    swap(bolts , j , i);
                    break;
                }
            }
        }
    }

    public void swap(String[] bolts , int start , int end){
        String temp = bolts[start];
        bolts[start] = bolts[end];
        bolts[end] = temp;
    }

    public static void main(String[] args) {
        LintCode_399 lintCode_399 = new LintCode_399();
        lintCode_399.sortNutsAndBolts(new String[]{"ab", "bc", "dd", "gg"}, new String[]{"AB", "GG", "DD", "BC"}, new NBCompare());
        System.out.println("xxx");
    }
}
