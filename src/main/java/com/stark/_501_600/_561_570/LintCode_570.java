package com.stark._501_600._561_570;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Stark on 2017/12/4.
 * 给一个由 1 - n 的整数随机组成的一个字符串序列，其中丢失了一个整数，请找到它。
 */
public class LintCode_570 {
    public int findMissing2(int n, String str) {
        // write your code here
        boolean[] visited = new boolean[n + 1];
        return find(n, 0, str, visited);
    }

    private int find(int n, int pos, String str, boolean[] visited) {
        if (pos == str.length()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) list.add(i);
            }
            if (list.size() == 1) return list.get(0);
            else return -1;
        }
        if (str.charAt(pos) == '0') return -1;
        for (int i = 1; i < 3; i++) {
            if (pos + i > str.length()) continue;
            int num = Integer.parseInt(str.substring(pos, pos + i));
            if (num >= 1 && num <= n && !visited[num]) {
                visited[num] = true;
                int val = find(n, pos + i, str, visited);
                if (val != -1) {
                    return val;
                }
                visited[num] = false;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LintCode_570 test = new LintCode_570();
        int missing2 = test.findMissing2(3, "21");
        System.out.println(missing2);
    }

}
