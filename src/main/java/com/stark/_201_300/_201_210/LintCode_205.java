package com.stark._201_300._201_210;

import com.stark.entity.Interval;
import com.stark.entity.SegmentTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_205 {

    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        // write your code here
        int begin = 0;
        int end = A.length - 1;
        List<Integer> res = new ArrayList<>();
        //构建线段树
        SegmentTreeNode node = getNode(begin, end, A);
        for (Interval interval : queries) {
            res.add(query(node, interval.start, interval.end));
        }
        return res;
    }

    private Integer query(SegmentTreeNode node, int start, int end) {
        if (start > end || node == null) return Integer.MAX_VALUE;
        int left = node.start;
        int right = node.end;
        if (start == left && right == end) return node.max;
        int mid = left + (right - left) / 2;
        return Math.min(query(node.left, Math.max(left, start), Math.min(mid, end)),
                query(node.right, Math.max(mid + 1, start), Math.min(end, right)));
    }

    private SegmentTreeNode getNode(int begin, int end, int[] a) {
        SegmentTreeNode node = new SegmentTreeNode(begin, end);
        if (begin == end) {
            node.max = a[begin];
            return node;
        }
        int mid = begin + (end - begin) / 2;
        node.left = getNode(begin, mid, a);
        node.right = getNode(mid + 1, end, a);
        node.max = Math.min(node.left.max, node.right.max);
        return node;
    }
}
