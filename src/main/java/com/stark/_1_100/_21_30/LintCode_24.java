package com.stark._1_100._21_30;

/**
 * Created by Stark on 2017/9/6.
 * LFU缓存算法实现
 */
public class LintCode_24 {
    //使用二维数组来存储
    Integer[][] cache;

    public LintCode_24(int capacity) {
        cache = new Integer[capacity][3];
    }

    public void set(int key, int value) {
        Integer[] newCome = new Integer[]{key, 0, value};
        int pos = cache.length - 1;
        for (; pos > 0; pos--) {
            if (cache[pos - 1] == null) {
                continue;
            }
            if (cache[pos - 1][1] != null && cache[pos - 1][1] != 0) {
                break;
            }
        }
        for (int i = cache.length - 2; i >= pos; i--) {
            cache[i + 1] = cache[i];
        }
        cache[pos] = newCome;
    }

    public int get(int key) {
        Integer pos = null;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i][0] == key) {
                pos = i;
                break;
            }
        }
        if (pos == null) {
            return -1;
        }
        cache[pos][1] = cache[pos][1] + 1;
        int time = cache[pos][1];
        //排序
        int begin = 0;
        int end = pos;
        for (; begin < end; begin++) {
            if (cache[begin][1] <= time) break;
        }
        Integer[] temp = cache[pos];
        for (int i = end - 1; i >= begin; i--) {
            cache[i + 1] = cache[i];
        }
        cache[begin] = temp;
        return temp[2];
    }

    public static void main(String[] args) {
        LintCode_24 test = new LintCode_24(3);
        test.set(1, 10);
        test.set(2, 20);
        test.set(3, 30);
        System.out.println(test.get(1));
        test.set(4, 40);
        System.out.println(test.get(4));
        System.out.println(test.get(3));
        System.out.println(test.get(2));
        System.out.println(test.get(1));
        test.set(5, 50);
        System.out.println(test.get(1));
        System.out.println(test.get(2));
        System.out.println(test.get(3));
        System.out.println(test.get(4));
        System.out.println(test.get(5));


    }
}
