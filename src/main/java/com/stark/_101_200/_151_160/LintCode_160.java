package com.stark._101_200._151_160;

/**
 * Created by Stark on 2017/10/3.
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 数组中可能存在重复的元素。
 */
public class LintCode_160 {
    public int findMin(int[] num) {
        // write your code here
        int left = 0;
        int right = num.length - 1;
        while(left < right){
            int mid = (left + right)/2;
            if(num[right] < num[mid]){
                left = mid + 1;
            }
            else if(num[mid] < num[left]){
                right = mid;
            }
            else{
                right--;
            }
        }
        return num[left];
    }
}
