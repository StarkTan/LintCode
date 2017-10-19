package com.stark._201_300._201_210;

import com.stark.entity.SegmentTreeNode;

/**
 * Created by Stark on 2017/10/18.
 * 对于一棵 最大线段树, 每个节点包含一个额外的 max 属性，用于存储该节点所代表区间的最大值。
 * 设计一个 modify 的方法，接受三个参数 root、 index 和 value。
 * 该方法将 root 为根的线段树中 [start, end] = [index, index] 的节点修改为了新的 value ，
 * 并确保在修改后，线段树的每个节点的 max 属性仍然具有正确的值。
 */
public class LintCode_203 {
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root.end == index && root.start == index) {
            root.max = value;
            return;
        }
        int mid = (root.end + root.start) / 2;
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }
        root.max = Math.max(root.right.max,root.left.max);
    }
}
