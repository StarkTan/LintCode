package com.stark._1_100._31_40;

/**
 * Created by Stark on 2017/9/14.
 *
 */
public class LintCode_38 {
    public int searchMatrix(int[][] matrix, int target) {
        int res = 0;
        int m = matrix.length-1;
        if(m==-1){
            return res;
        }
        int n = matrix[0].length;

        int x = m;
        int y = 0;
        while(x>=0&&y<=n){
            int cur = matrix[x][y];
            if(target>cur){
                y++;
            }else if(target==cur){
                res++;
                y++;
            }else {
                x--;
            }
        }
        return res;
    }
}
