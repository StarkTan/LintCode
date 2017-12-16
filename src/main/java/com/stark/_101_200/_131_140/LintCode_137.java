package com.stark._101_200._131_140;

import com.stark.entity.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_137 {

    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode next : node.neighbors) {
            newNode.neighbors.add(cloneGraph(next));
        }
        return newNode;
    }

    public static void main(String[] args) {
        LintCode_137 lintCode_137 = new LintCode_137();
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        UndirectedGraphNode two = new UndirectedGraphNode(2);
        one.neighbors.add(two);
        two.neighbors.add(one);
        lintCode_137.cloneGraph(one);
    }
}
