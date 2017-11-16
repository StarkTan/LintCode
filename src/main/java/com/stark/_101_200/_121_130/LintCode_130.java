package com.stark._101_200._121_130;

/**
 * Created by Stark on 2017/11/16.
 * 给出一个整数数组，堆化操作就是把它变成一个最小堆数组。
 * 对于堆数组A，A[0]是堆的根，并对于每个A[i]，A [i * 2 + 1]是A[i]的左儿子并且A[i * 2 + 2]是A[i]的右儿子。
 */
public class LintCode_130 {
    public void heapify(int[] A) {
        // write your code here
        int len = A.length;
        int temp;
        //构建堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            keepSmallHeap(A, i, len);
        }
    }

    //维护小顶堆性质
    private static void keepSmallHeap(int[] arr, int node, int len) {
        int l = node * 2 + 1;
        int r = node * 2 + 2;
        int smallest = node;
        int temp;
        if (len > l && arr[l] < arr[smallest]) {
            smallest = l;
        }
        if (len > r && arr[r] < arr[smallest]) {
            smallest = r;
        }
        if (smallest != node) {//发生交换
            temp = arr[smallest];
            arr[smallest] = arr[node];
            arr[node] = temp;
            keepSmallHeap(arr, smallest, len);
        }
    }
}
