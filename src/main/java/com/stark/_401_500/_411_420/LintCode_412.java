package com.stark._401_500._411_420;

/**
 * Created by Stark on 2017/10/3.
 * 有 N 个小孩站成一列。每个小孩有一个评级。
 * 按照以下要求，给小孩分糖果：
 * 每个小孩至少得到一颗糖果。
 * 评级越高的小孩可以比他相邻的两个小孩得到更多的糖果。
 * 需最少准备多少糖果？
 */
public class LintCode_412 {
    public int candy(int[] ratings) {
        // write your code here
        int len = ratings.length;
        int[] candy = new int[len];
        //right
        for (int i = 0; i < len - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candy[i+1] = Math.max(candy[i+1],candy[i]+1);
            }
        }
        for (int i = len - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candy[i-1] = Math.max(candy[i-1],candy[i]+1);
            }
        }
        int res = len;
        for(int i:candy){
            res +=i;
        }
        return res;
    }
}
