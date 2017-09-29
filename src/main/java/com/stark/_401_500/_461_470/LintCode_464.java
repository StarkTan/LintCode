package com.stark._401_500._461_470;

/**
 * Created by Stark on 2017/9/29.
 * 快排
 */
public class LintCode_464 {
    public void sortIntegers2(int[] A) {
        int begin = 0;
        int end = A.length - 1;
        faster(A,begin,end);
    }
    private static void faster(int[] arr, int begin, int end) {
        if (begin >= end) return;
        int key = arr[begin];//分界值
        int pos = begin; //初始交换位
        int i = begin + 1;
        int j = end;
        boolean right = true; //从右扫描
        while (i <= j) {
            if (right) {
                if (arr[j] < key) {//不变
                    arr[pos] = arr[j];
                    pos = j;
                    right = false;
                }
                j--;
            } else {
                if (arr[i] > key) {
                    arr[pos] = arr[i];
                    pos = i;
                    right = true;
                }
                i++;
            }
        }
        arr[pos] = key;
        //开始递归
        faster(arr, begin, pos - 1);
        faster(arr, pos + 1, end);
    }
}
