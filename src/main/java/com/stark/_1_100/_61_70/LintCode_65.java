package com.stark._1_100._61_70;

/**
 * Created by Stark on 2017/11/29.
 * 两个排序的数组A和B分别含有m和n个数，找到两个排序数组的中位数，要求时间复杂度应为O(log (m+n))。
 * TODO 失败
 */
public class LintCode_65 {

    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int m = A.length;
        int n = B.length;
        int total = m + n;
        if (total % 2 == 1) return findKth(A, 0, B, 0, total / 2 + 1);
        else return (findKth(A, 0, B, 0, total / 2) + findKth(A, 0, B, 0, total / 2 + 1));
    }

    private double findKth(int[] a, int starta, int[] b, int startb, int k) {
        if (a.length - starta > b.length - startb) return findKth(b, startb, a, starta, k);
        if (a.length == 0) return b[startb + k - 1];
        if (k == 1) return Math.min(a[starta], b[startb]);
        int posa = Math.min(starta + k / 2, a.length);
        int posb = startb + k - posa + starta;
        if (a[posa - 1] < b[posb - 1])
            return findKth(a, posa, b, posb, k - posa + starta);
        else if (a[posa - 1] > b[posb - 1])
            return findKth(a, starta, b, posb, k - posb + startb);
        else {
            return a[posa - 1];
        }
    }

    public static void main(String[] args) {
        LintCode_65 test = new LintCode_65();
        double medianSortedArrays = test.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        System.out.println(medianSortedArrays);
    }
}
