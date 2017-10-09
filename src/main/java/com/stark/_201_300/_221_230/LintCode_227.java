package com.stark._201_300._221_230;

import java.util.Stack;

/**
 * Created by Stark on 2017/10/9.
 * 在经典的汉诺塔问题中，有 3 个塔和 N 个可用来堆砌成塔的不同大小的盘子。要求盘子必须按照从小到大的顺序从上往下堆 （如，任意一个盘子，其必须堆在比它大的盘子上面）。
 * 同时，你必须满足以下限制条件：
 * (1) 每次只能移动一个盘子。
 * (2) 每个盘子从堆的顶部被移动后，只能置放于下一个堆中。
 * (3) 每个盘子只能放在比它大的盘子上面。
 * 请写一段程序，实现将第一个堆的盘子移动到最后一个堆中。
 */

//227
public class LintCode_227 {
    private Stack<Integer> disks;

    /*
    * @param i: An integer from 0 to 2
    */
    public LintCode_227(int i) {
        // create three towers
        disks = new Stack<>();
    }

    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(LintCode_227 t) {
        // Move the top disk of this tower to the top of t.
        t.add(disks.pop());
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    public void moveDisks(int n, LintCode_227 destination, LintCode_227 buffer) {
        // Move n Disks from this tower to destination by buffer tower
        if (n == 0) return;
        moveDisks(n - 1, buffer, destination);
        moveTopTo(destination);
        buffer.moveDisks(n - 1, destination, this);

    }

    /*
     * @return: Disks
     */
    public Stack<Integer> getDisks() {
        // write your code here
        return disks;
    }

    public static void main(String[] args) {
        LintCode_227[] towers = new LintCode_227[3];
        for (int i = 0; i < 3; i++) towers[i] = new LintCode_227(i);
        for (int i = 3 - 1; i >= 0; i--) towers[0].add(i);
        towers[0].moveDisks(3, towers[2], towers[1]);
        System.out.println(11);
    }
}
