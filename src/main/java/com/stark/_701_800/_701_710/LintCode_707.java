package com.stark._701_800._701_710;

import java.util.*;

/**
 * Created by Stark on 2018/3/2.
 * 第一版：排序拼凑，算法错误
 * 第二版：动态递归，超时。
 * 第三版：取半数组求解，算法错误
 * 第四版：使用最多半数指针判断是否存在闭环，算法不完整
 * 第五版：算法补充，旋转数组判断，OK
 * 总结：时间复杂度任然是 n！，只是进行优化，如果当数组长度达到28，且排序复杂的话，耗时明显变长
 */
public class LintCode_707 {

    int res = 0;
    int delete = 0;
    private boolean stop = false;

    public int balanceGraph(int[][] edges) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ints : edges) {
            int begin = ints[0];
            int end = ints[1];
            int value = ints[2];
            int begin_weight;
            int end_weight;
            if (map.containsKey(begin)) {
                begin_weight = map.get(begin);
            } else {
                begin_weight = 0;
            }
            if (map.containsKey(end)) {
                end_weight = map.get(end);
            } else {
                end_weight = 0;
            }
            begin_weight = begin_weight + value;
            end_weight = end_weight - value;
            map.put(begin, begin_weight);
            map.put(end, end_weight);

        }
        Collection<Integer> values = map.values();
        int[] ints = new int[values.size()];
        int i = 0;
        for (int value : values) {
            ints[i++] = value;
        }
        res = values.size();
        Stack<Integer> pos = new Stack<>();
        ints = dealres(ints, pos);
        while (ints.length > 0) {
            stop = false;
            ints = resolve(ints, pos);
        }
        return res;
    }

    private int[] resolve(int[] ints, Stack<Integer> pos) {
        for (int i = 2; i <= ints.length / 2 + 2; i++) {
            for (int j = 0; j < ints.length; j++) {
                find_pos(ints, pos, j, i, 0, true);
                if (stop) break;
            }
            if (stop) break;
        }
        if (!pos.isEmpty()) {
            return dealres(ints, pos);
        } else {
            res--;
            return new int[]{};
        }
    }

    private void find_pos(int[] ints, Stack<Integer> stack, int begin, int mount, int num, boolean main) {
        int len = ints.length;
        if (len - begin < mount) return;
        if (mount < 1) return;
        num = num + ints[begin];
        stack.push(begin);
        if (num == 0) {
            stop = true;
            return;
        }
        for (int i = begin + 1; i < len; i++) {
            find_pos(ints, stack, i, mount - 1, num, false);
            if (stop) return;
        }
        stack.pop();
    }

    private int[] dealres(int[] ints, Stack<Integer> pos) {
        int length = ints.length;
        if (pos.isEmpty()) {
            int zero_num = 0;
            for (int i : ints) {
                if (i == 0) zero_num++;
            }
            if (zero_num == 0) {
                return ints;
            } else {
                res -= zero_num;
                int[] ints1 = new int[length - zero_num];
                int i = 0;
                for (int j : ints) {
                    if (j != 0) ints1[i++] = j;
                }
                return ints1;
            }
        } else {
            int[] ints1 = new int[length - pos.size()];
            int i = 0;
            for (int j = 0; j < ints.length; j++) {
                if (!pos.contains(j)) {
                    ints1[i++] = ints[j];
                }
            }
            int[] ints2 = new int[pos.size()];
            i = 0;
            while (!pos.isEmpty()) {
                ints2[i++] = ints[pos.pop()];
            }
            //进行清理
            int i1 = deal_part(ints2, 0, 0);
            res = res - i1;
            delete = 0;
            return ints1;
        }
    }

    private int deal_part(int[] ints, int ex, int begin) {
        int total = ints.length;
        if (begin >= total) {
            if (ex > delete) {
                delete = ex;
            }
        } else {
            int current = ints[begin];
            if (current == 0) {
                ex++;
                //System.out.println(begin);
                deal_part(ints, ex, begin + 1);
            } else {
                for (int i = begin + 1; i < total; i++) {
                    ints[i] = ints[i] + current;
                    deal_part(ints, ex, begin + 1);
                    ints[i] = ints[i] - current;
                }
            }
        }
        return delete;
    }

    public static void main(String[] args) {
        LintCode_707 lintCode_707 = new LintCode_707();
        //int[][] test = new int[][]{{16, 3, 9359}, {1, 10, 8146}, {14, 16, 492}, {5, 10, 6501}, {8, 16, 5437}, {1, 9, 154}, {6, 13, 8717}, {5, 7, 1727}, {12, 16, 9913}, {0, 1, 9895}, {11, 8, 334}, {6, 11, 7712}, {0, 13, 7645}, {15, 11, 2860}, {0, 6, 779}, {9, 5, 1843}, {16, 13, 8943}, {4, 8, 3806}, {14, 9, 5351}, {8, 15, 3549}, {9, 12, 9955}, {8, 2, 7377}, {9, 12, 2440}, {1, 12, 1539}, {8, 13, 6542}, {5, 15, 9659}, {2, 3, 2307}, {14, 6, 8746}, {15, 14, 5830}, {1, 14, 6513}, {13, 15, 8637}, {15, 8, 5575}, {16, 14, 1151}, {15, 9, 3431}, {16, 4, 1338}, {13, 9, 384}, {1, 11, 9759}, {7, 13, 4947}, {8, 13, 901}, {11, 6, 7411}, {16, 1, 1549}, {4, 12, 3603}, {6, 15, 9375}, {6, 0, 7349}, {16, 4, 8282}, {2, 10, 6419}, {15, 14, 8128}, {5, 1, 4649}, {8, 7, 4311}, {16, 11, 4310}};
        int[][] test = new int[][]{{16, 15, 501}, {9, 11, 359}, {0, 1, 146}, {14, 15, 492}, {16, 11, 437}, {14, 13, 154}, {6, 5, 717}, {7, 6, 772}, {5, 0, 668}, {15, 11, 704}, {10, 11, 674}, {5, 7, 254}, {3, 4, 663}, {11, 15, 724}, {15, 12, 317}, {13, 14, 289}, {0, 6, 265}, {6, 5, 891}, {15, 13, 7}, {11, 10, 630}, {8, 9, 757}, {6, 0, 932}, {0, 7, 627}, {10, 9, 119}, {1, 5, 834}, {12, 11, 705}, {1, 2, 674}, {5, 1, 925}, {6, 5, 778}, {11, 14, 987}, {1, 4, 356}, {11, 12, 32}, {6, 5, 725}, {6, 3, 192}, {14, 12, 288}, {14, 13, 910}, {10, 11, 423}, {2, 6, 414}, {4, 7, 763}, {12, 13, 625}, {10, 11, 596}, {10, 13, 292}, {6, 4, 597}, {14, 11, 485}, {8, 16, 1000}, {2, 4, 789}, {16, 10, 894}, {3, 7, 422}, {1, 5, 515}, {10, 16, 452}, {1, 7, 557}, {7, 0, 9}, {1, 5, 703}, {9, 14, 344}, {11, 9, 504}, {0, 2, 619}, {4, 6, 282}, {16, 9, 158}, {6, 2, 293}, {3, 6, 658}, {7, 0, 157}, {10, 14, 273}, {14, 10, 363}, {3, 1, 870}, {4, 0, 882}, {2, 3, 22}, {10, 8, 893}, {16, 10, 601}, {3, 5, 862}, {1, 5, 256}, {15, 9, 183}, {15, 14, 758}, {4, 1, 155}, {16, 13, 330}, {4, 1, 556}, {5, 1, 513}, {14, 9, 754}, {11, 15, 997}, {9, 12, 438}, {5, 1, 196}};
        long l = System.currentTimeMillis();
        System.out.println(lintCode_707.balanceGraph(test));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);


    }
}
