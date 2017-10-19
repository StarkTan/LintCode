package com.stark.entity;

/**
 * Created by Stark on 2017/9/17.
 * 线段树
 */
public class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
}
