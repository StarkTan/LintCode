package com.stark._501_600._531_540;

import com.stark.entity.TreeNode;

import java.util.Stack;

/**
 * Created by Stark on 2017/10/11.
 * 在上次打劫完一条街道之后和一圈房屋之后，窃贼又发现了一个新的可以打劫的地方，
 * 但这次所有的房子组成的区域比较奇怪，聪明的窃贼考察地形之后，发现这次的地形是一颗二叉树。
 * 与前两次偷窃相似的是每个房子都存放着特定金额的钱。
 * 你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且当相邻的两个房子同一天被打劫时，该系统会自动报警。
 * 算一算，如果今晚去打劫，你最多可以得到多少钱，当然在不触动报警装置的情况下。
 */
public class LintCode_535 {
    public int houseRobber3(TreeNode root) {
        // write your code here
        int[] res = solve(root);
        return Math.max(res[0], res[1]);
    }

    private int[] solve(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] res = new int[2];
        int[] left = solve(root.left);
        int[] right = solve(root.right);

        //0表示偷当前节点，1表示不偷当前节点
        res[0] = left[1] + right[1] + root.val;

        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }

}
