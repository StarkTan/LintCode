package com.stark._201_300._241_250;

import com.stark.entity.SegmentTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/18.
 * 给定一个整数数组（下标由 0 到 n-1， n 表示数组的规模，取值范围由 0 到10000）。
 * 对于数组中的每个 ai 元素，请计算 ai 前的数中比它小的元素的数量。
 * <p>
 * //线段树 最大值到最小值，匹配个数
 */
public class LintCode_249 {

    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        //构造0-10000的线段树
        SegmentTreeNode node = getSegmentTreeNode(0, 10000);
        int len = A.length;
        List<Integer> list = new ArrayList<>();
        for (int i : A) {
            list.add(solve(node, i));
        }
        return list;
    }

    private Integer solve(SegmentTreeNode node, int i) {
        int res = 0;
        if (node.end == node.start) {
            node.max++;
            return res;
        }
        int mid = (node.end + node.start) / 2;
        if (i > mid) {
            res = solve(node.right, i) + node.left.max;
        } else {
            res = solve(node.left, i);
        }
        node.max++;
        return res;
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


    //线段树模型
//    class SegmentTreeNode {
//        public int start, end, max;
//        public SegmentTreeNode left, right;
//
//        public SegmentTreeNode(int start, int end) {
//            this.start = start;
//            this.end = end;
//            this.left = this.right = null;
//        }
//    }
}
