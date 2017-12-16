package com.stark.entity;

import java.util.ArrayList;

/**
 * Created by Stark on 2017/12/8.
 */
public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
