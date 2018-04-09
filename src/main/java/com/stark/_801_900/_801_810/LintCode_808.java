package com.stark._801_900._801_810;

import java.util.*;

/**
 * Created by Stark on 2018/3/23.
 * TODO
 */
public class LintCode_808 {
    public int[] topKMovie(int[] rating, int[][] G, int S, int K) {
        // Write your code here
        //1.根据S进行深度遍历，找到关联对象
        Stack<Integer> stack = new Stack<>();
        stack.push(S);
        Set<Integer> res = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (visited.contains(pop)) {
                continue;
            }
            visited.add(pop);
            for (int i : G[pop]) {
                stack.push(i);
                if (!visited.contains(i))
                    res.add(i);
            }
        }

        //获取rate值进入数组进行排序
        int j = 0;
        int[][] rates = new int[res.size()][2];
        for (int i : res) {
            rates[j][0] = rating[i];
            rates[j][1] = i;
            j++;
        }
        /*Arrays.sort(rates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });*/
        int len = rates.length;
        for (int i = 0; i < len - 1; i++) {
            for (int k = i; k < len; k++) {
                if (rates[i][0] < rates[k][0]) {
                    int[] temp = rates[i];
                    rates[i] = rates[k];
                    rates[k] = temp;
                }
            }
        }


        int[] res_rat = new int[K];
        for (int i = 0; i < K; i++) {
            res_rat[i] = rates[i][1];
        }
        return res_rat;
    }

    public static void main(String[] args) {
        int[] rating = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int[][] G = {{1, 4, 5}, {0, 2, 3}, {1, 7}, {1, 6, 7}, {0}, {0}, {3}, {2, 3}, {}};
        int[] ints = new LintCode_808().topKMovie(rating, G, 5, 3);
        System.out.println(Arrays.toString(ints));
    }
}
