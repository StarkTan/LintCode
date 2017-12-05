package com.stark.entity;

/**
 * Created by Stark on 2017/12/5.
 */
public class NBCompare {
    public int cmp(String a, String b) {
        if (a.equals(b.toLowerCase())) return 0;
        else return 1;
    }
}
