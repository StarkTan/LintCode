package com.stark._701_800._721_730;

/**
 * Created by Stark on 2017/12/7.
 * 中国剩余定理
 */
public class LintCode_727 {
    public int remainderTheorem(int[] num, int[] rem) {
        // write your code here
        long product = 1;
        for (int n : num)
            product *= n;
        long total = 0;
        for (int i = 0; i < num.length; i++) {
            int n = num[i];
            long leftProduct = product / n;
            long copy = leftProduct;
            while (copy % n != 1) {
                copy += leftProduct;
            }
            total += (copy * rem[i]);
        }
        return (int) (total % product);
    }

    public static void main(String[] args) {
        LintCode_727 test = new LintCode_727();
        int i = test.remainderTheorem(new int[]{3, 4, 5}, new int[]{2, 3, 1});
        System.out.println(i);
    }
}
