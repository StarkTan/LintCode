package com.stark._201_300._211_220;

import java.util.Arrays;

/**
 * Created by Stark on 2017/9/17.
 * 给定两个字符串，请设计一个方法来判定其中一个字符串是否为另一个字符串的置换。
 * <p>
 * 置换的意思是，通过改变顺序可以使得两个字符串相等。
 */
public class LintCode_211 {
    public boolean Permutation(String A, String B) {
        if (A == null || B == null) return false;
        int lena = A.length();
        int lenb = B.length();
        if (lena != lenb) return false;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < lena; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
