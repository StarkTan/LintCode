package com.stark._101_200._171_180;

import com.stark.entity.DirectedGraphNode;
import com.stark.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/10/3.
 * 给出一张有向图，设计一个算法判断两个点 s 与 t 之间是否存在路线。
 */
public class LintCode_176 {
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s,
                            DirectedGraphNode t) {
        // write your code here
        if(graph.isEmpty()) return false;
        List<Integer> list = new ArrayList<>();
        for(DirectedGraphNode node:graph){
            int label = node.label;
            if(label == s.label){
                list.add(label);
                if(s.label == t.label) return true;
                return getSolve(list,node.neighbors,t);
            }
        }
        return false;
    }

    private boolean getSolve(List<Integer> list, ArrayList<DirectedGraphNode> graph, DirectedGraphNode t) {

        if(graph.isEmpty()) return false;
        for(DirectedGraphNode node:graph){
            int label = node.label;
            if(label==t.label) return true;
            if(!list.contains(label)){
                list.add(label);
                if(getSolve(list,node.neighbors,t)){
                    return true;
                }
            }
        }

        return false;
    }

}
