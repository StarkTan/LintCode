package com.stark._301_400._391_400;

/**
 * Created by Stark on 2017/9/30.
 * 有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。拿到最后一枚硬币的人获胜。
 * 请判定 第一个玩家 是输还是赢？
 */
public class LintCode_394 {
    public boolean firstWillWin(int n) {
        /*递归超时
        if(n==1){
            return true;
        }
        if(n==2){
            return true;
        }
        if(n==3){
            return false;
        }
        return !(firstWillWin(n-1)||firstWillWin(n-2));*/
        return n%3!=0;
    }
}
