package com.stark._401_500._421_430;

import java.util.Arrays;

/**
 * Created by Stark on 2017/10/17.
 * 给定一个文档(Unix-style)的完全路径，请进行路径简化。
 * "/home/", => "/home"
 * "/a/./b/../../c/", => "/c"
 */
public class LintCode_421 {
    public String simplifyPath(String path) {
        // write your code here
        //简化path //->/
        //path = path.replaceAll("//", "/");
        String[] arr = path.split("/");
        if (arr.length == 0) {
            return "/";
        }
        arr[0] = null;
        for (int i = 1; i < arr.length; i++) {
            String cur = arr[i];
            if (cur.equals("")) {
                arr[i] = null;
            } else if (cur.equals(".")) {
                arr[i] = null;
            } else if (cur.equals("..")) {
                for (int j = i - 1; j >= 1; j--) {
                    if (arr[j] != null) {
                        arr[j] = null;
                        break;
                    }
                }
                arr[i] = null;
            }
        }
        StringBuilder res = new StringBuilder();
        for (String s : arr) {
            if (s != null) {
                res.append("/").append(s);
            }
        }
        if (res.length() == 0) {
            res.append("/");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_421().simplifyPath("/home/"));
    }
}
