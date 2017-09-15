package com.stark._1_100._51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/9/15.
 *给定一个整数数组来表示排列，找出其上一个排列。
 */
public class LintCode_51 {
    public List<Integer> previousPermuation(List<Integer> nums) {
        int size = nums.size();
        int upper = size; //修改的开始位置
        for (int i = size - 2; i >= 0; i--) {
            if (nums.get(i) > nums.get(i + 1)) {
                upper = i;
                break;
            }
        }
        if(upper==size){
            //全部反转
            myResorve(0,size-1,nums);
            return nums;
        }
        int num = nums.get(upper);
        int firstSmall = size;
        for (int i = size - 1; i >= 0; i--) {
            if (nums.get(i) < num) {
                firstSmall = i;
                break;
            }
        }
        //交换
        int temp = nums.get(firstSmall);
        nums.set(firstSmall,nums.get(upper));
        nums.set(upper,temp);
        //从upper+1倒序
        int begin = upper+1;
        int end = size-1;
        myResorve(begin,end,nums);
        return nums;
    }

    private void myResorve(int begin, int end, List<Integer> nums) {
        while(end>begin){
            int temp = nums.get(begin);
            nums.set(begin,nums.get(end));
            nums.set(end,temp);
            begin++;
            end--;
        }
    }
}
