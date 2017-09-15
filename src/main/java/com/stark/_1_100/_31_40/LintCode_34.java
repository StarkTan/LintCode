package com.stark._1_100._31_40;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/9/14.
 *根据n皇后问题，现在返回n皇后不同的解决方案的数量而不是具体的放置布局。
 * 在上一题中已经解决
 */
public class LintCode_34 {
    public int totalNQueens(int n){
        int res=0;
        //初始化数据，使用一维数组代替棋盘
        Integer[] chessboard = new Integer[n];
        chessboard[0]=0;
        int row =0;
        while(chessboard[0]<n){ //结束条件
            if(chessboard[row]>=n){
                row--;
                chessboard[row]++;
                continue;
            }

            boolean confir = confir(chessboard, row);
            if(confir){
                if(row==n-1){
                    res++;
                    chessboard[row]++;
                }else {
                    row++;
                    chessboard[row]=0;
                }
            }else {
                chessboard[row]++;
            }
        }
        return res;
    }
    //验证方法
    private boolean confir(Integer[] chessboard,int row){
        int cur = chessboard[row];
        for(int i=0;i<row;i++){
            int com = chessboard[i];//当前比较行
            int step = row-i;
            if(com==cur||com+step==cur||com-step==cur){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_34().totalNQueens(10));
    }
}
