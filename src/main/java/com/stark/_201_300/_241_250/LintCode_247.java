package com.stark._201_300._241_250;

import com.stark.entity.SegmentTreeNode;

/**
 * Created by Stark on 2017/12/5.
 * 对于一个数组，我们可以对其建立一棵 线段树, 每个结点存储一个额外的值 count 来代表这个结点所指代的数组区间内的元素个数.
 * (数组中并不一定每个位置上都有元素)
 * <p>
 * 实现一个 query 的方法，该方法接受三个参数 root, start 和 end, 分别代表线段树的根节点和需要查询的区间，
 * 找到数组中在区间[start, end]内的元素个数。
 */
public class LintCode_247 {

    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        int res = 0;
        if (root == null || start > end) return res;
        int left = root.start;
        int right = root.end;
        if (left == start && right == end) return root.max;
        int mid = left + (right - left) / 2;
        res += query(root.left, Math.max(left, start), Math.min(end, mid));
        res += query(root.right, Math.max(mid + 1, start), Math.min(end, right));
        return res;
    }
}
