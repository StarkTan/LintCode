package com.stark._101_200._181_190;

/**
 * Created by Stark on 2017/12/6.
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油gas[i]，并且从第_i_个加油站前往第_i_+1个加油站需要消耗汽油cost[i]。
 * <p>
 * 你有一辆油箱容量无限大的汽车，现在要从某一个加油站出发绕环路一周，一开始油箱为空。
 * <p>
 * 求可环绕环路一周时出发的加油站的编号，若不存在环绕一周的方案，则返回-1。
 */
public class LintCode_187 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int start = i;
            int gas_left = 0;
            boolean[] visit = new boolean[len];
            while (!visit[start % len] && gas_left >= 0) {
                gas_left += gas[start % len];
                gas_left -= cost[start % len];
                visit[start % len] = true;
                start++;
            }
            if (start % len == i && gas_left >= 0) return i;
        }
        return -1;
    }
}
