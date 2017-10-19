package com.stark._201_300._241_250;

import com.stark.entity.SegmentTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/19.
 * 给定一个整数数组 （下标由 0 到 n-1，其中 n 表示数组的规模，数值范围由 0 到 10000），
 * 以及一个 查询列表。对于每一个查询，将会给你一个整数，请你返回该数组中小于给定整数的元素的数量。
 */
public class LintCode_248 {
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        SegmentTreeNode node = getSegmentTreeNode(0, 10000);
        int len = A.length;
        List<Integer> list = new ArrayList<>();
        for (int i : A) {
            build(node, i);
        }
        for (int i : queries) {
            list.add(query(node, i));
        }
        return list;
    }

    private Integer query(SegmentTreeNode node, int i) {
        int res = 0;
        if (node.end == node.start) {
            return res;
        }
        int mid = (node.end + node.start) / 2;
        if (i > mid) {
            res = query(node.right, i) + node.left.max;
        } else {
            res = query(node.left, i);
        }
        return res;
    }

    private void build(SegmentTreeNode node, int i) {
        if (node.end == node.start) {
            node.max++;
            return;
        }
        int mid = (node.end + node.start) / 2;
        if (i > mid) {
            build(node.right, i);
        } else {
            build(node.left, i);
        }
        node.max++;
    }

    private SegmentTreeNode getSegmentTreeNode(int begin, int end) {
        SegmentTreeNode segmentTreeNode = new SegmentTreeNode(begin, end);
        if (begin < end) {
            int mid = (begin + end) / 2;
            segmentTreeNode.left = getSegmentTreeNode(begin, mid);
            segmentTreeNode.right = getSegmentTreeNode(mid + 1, end);
        }
        return segmentTreeNode;
    }
}
