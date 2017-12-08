package com.stark._201_300._201_210;


/**
 * Created by Stark on 2017/12/6.
 */
public class LintCode_207 {

    private SegmentTreeNode node = null;

    public LintCode_207(int[] A) {
        int begin = 0;
        int end = A.length - 1;
        if (begin > end) return;
        this.node = getNode(A, begin, end);
    }

    private SegmentTreeNode getNode(int[] a, int begin, int end) {
        SegmentTreeNode node = new SegmentTreeNode(begin, end);
        if (begin == end) {
            node.total = a[begin];
            return node;
        }
        int mid = begin + (end - begin) / 2;
        node.left = getNode(a, begin, mid);
        node.right = getNode(a, mid + 1, end);
        node.total = node.left.total + node.right.total;
        return node;
    }

    public long query(int start, int end) {
        // write your code here
        return query(node, start, end);

    }

    private long query(SegmentTreeNode node, int start, int end) {
        if (node == null || start > end) return 0;
        int left = node.start;
        int right = node.end;
        if (left == start && end == right) return node.total;
        long res = 0;
        int mid = left + (right - left) / 2;
        res += query(node.left, Math.max(left, start), Math.min(mid, end));
        res += query(node.right, Math.max(mid + 1, start), Math.min(right, end));
        return res;
    }

    public void modify(int index, int value) {
        // write your code here
        modify(node, index, value);
    }

    private long modify(SegmentTreeNode node, int index, int value) {
        int left = node.start;
        int right = node.end;
        if (left == right && left == index) {
            long count = node.total;
            long res = count - value;
            node.total = value;
            return res;
        }
        int mid = left + (right - left) / 2;
        long modify = 0;
        if (index <= mid && index >= left)
            modify = modify(node.left, index, value);
        if (index >= mid + 1 && index <= right) modify = modify(node.right, index, value);
        node.total = node.total - modify;
        return modify;
    }

    public class SegmentTreeNode {
        public int start;
        public int end;
        public long total;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
