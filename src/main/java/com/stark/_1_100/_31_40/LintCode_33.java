package com.stark._1_100._31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/9/13.
 * n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。
 * 给定一个整数n，返回所有不同的n皇后问题的解决方案。
 * 每个解决方案包含一个明确的n皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。
 */
public class LintCode_33 {
    //使用递归
    public List<List<String>> solveNQueens_V1(int n) {
        //初始化数据，使用一维数组代替棋盘
        Integer[] chessboard = new Integer[n];
        List<List<String>> res = new ArrayList<>();
        int begin = 0;
        //处理函数
        solve(chessboard,begin,n,res);
        return res;
    }

    private void solve(Integer[] chessboard, int begin, int n, List<List<String>> res) {
        //完成排列
        if(begin==n){
            //根据数组转化成字符串
            List<String> list = new ArrayList<String>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder("");
                for(int j=0;j<n;j++){
                    if(j==chessboard[i]){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for(int i=0;i<n;i++){
            chessboard[begin]=i;
            if(confir(chessboard,begin)){
                Integer[] copy = Arrays.copyOf(chessboard,n);
                solve(copy,begin+1,n,res);
            }
        }
    }
    //不使用递归
    public List<List<String>> solveNQueens_V2(int n){
        //初始化数据，使用一维数组代替棋盘
        Integer[] chessboard = new Integer[n];
        List<List<String>> res = new ArrayList<>();
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
                    List<String> list = new ArrayList<String>();
                    for(int i=0;i<n;i++){
                        StringBuilder sb = new StringBuilder();
                        for(int j=0;j<n;j++){
                            if(j==chessboard[i]){
                                sb.append("Q");
                            }else {
                                sb.append(".");
                            }
                        }
                        list.add(sb.toString());
                    }
                    res.add(list);

                    chessboard[row]++;
                }else {
                    row++;
                    chessboard[row]=0;
                }
            }else {
                chessboard[row]++;
            }
        }
        //处理函数
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
        List<List<String>> lists = new LintCode_33().solveNQueens_V2(4);
        System.out.println(lists);
    }
}
