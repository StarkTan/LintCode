package com.stark.entity;

/**
 * Created by Stark on 2017/9/21.
 *
 */
public class ExpressionTreeNode {
    public String symbol;
    public ExpressionTreeNode left, right;

    public ExpressionTreeNode(String symbol) {
        this.symbol = symbol;
        this.left = this.right = null;
    }
}
