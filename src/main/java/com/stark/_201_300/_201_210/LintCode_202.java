package com.stark._201_300._201_210;

import com.stark.entity.SegmentTreeNode;

/**
 * Created by Stark on 2017/10/18.
 * 对于一个有n个数的整数数组，在对应的线段树中, 根节点所代表的区间为0-n-1,
 * 每个节点有一个额外的属性max，值为该节点所代表的数组区间start到end内的最大值。
 * 为SegmentTree设计一个 query 的方法，接受3个参数root, start和end，
 * 线段树root所代表的数组中子区间[start, end]内的最大值。
 */
public class LintCode_202 {
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here

        //1
        if (root.start == start && root.end == end) {
            return root.max;
        }
        int mid = (root.start + root.end) / 2;
        //2
        if (start > mid) {
            return query(root.right, start, end);
        }
        if (end <= mid) {
            return query(root.left, start, end);
        }
        //3
        return Math.max(query(root.left, start, mid), query(root.right, mid + 1, end));
    }
}
