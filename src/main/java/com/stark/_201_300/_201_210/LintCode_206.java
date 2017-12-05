package com.stark._201_300._201_210;

import com.stark.entity.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/12/1.
 */
public class LintCode_206 {

    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        // write your code here
        /*占用空间多
        int len = A.length;
        long[][] dp = new long[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == j) dp[i][j] = A[j];
                else dp[i][j] = dp[i][j - 1] + A[j];
            }
        }
        List<Long> res = new ArrayList<>();
        for (Interval interval : queries) {
            res.add(dp[interval.start][interval.end]);
        }
        return res;*/
        //构造线段树
        SegmentTreeNode node = getSegmentTree(A, 0, A.length - 1);
        List<Long> res = new ArrayList<>();
        for (Interval val : queries) {
            res.add(query(node, val.start, val.end));
        }

        return res;
    }

    private long query(SegmentTreeNode node, int start, int end) {
        if (node == null) return 0;
        int left = node.start;
        int right = node.end;
        if (start > right || end < left) return 0;
        if (start == left && end == right) return node.max;

        int mid = (left + right) / 2;
        long res = 0;
        /*if (start <= mid) {
            res += query(node.left, Math.max(left, start), Math.min(mid, end));
        }
        if (end >= mid + 1) {
            res += query(node.right, Math.max(mid + 1, start), Math.min(right, end));
        }*/

        res += query(node.left, Math.max(left, start), Math.min(mid, end));
        res += query(node.right, Math.max(mid + 1, start), Math.min(end, right));
        return res;
    }

    private SegmentTreeNode getSegmentTree(int[] arr, int start, int end) {
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.max = arr[start];
        } else {
            int mid = (start + end) / 2;
            node.left = getSegmentTree(arr, start, mid);
            node.right = getSegmentTree(arr, mid + 1, end);
            node.max = node.left.max + node.right.max;
        }
        return node;
    }

    public static void main(String[] args) {
        LintCode_206 lintCode_206 = new LintCode_206();
        List<Interval> queries = new ArrayList<>();
        queries.add(new Interval(1, 2));
        List<Long> longs = lintCode_206.intervalSum(new int[]{1, 2, 7, 8, 5}, queries);
        System.out.println(longs);
    }

    class SegmentTreeNode {
        int start, end;
        long max;
        SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }
}
