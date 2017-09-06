package com.stark._1_100._21_30;

import com.stark.entity.NestedInteger;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Stark on 2017/9/6.
 *
 */
public class LintCode_22 {
    //递归
    public List<Integer> flatten_V1(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<Integer>();
        for(NestedInteger target : nestedList){
            if(target.isInteger()){
                res.add(target.getInteger());
            }else {
                res.addAll(flatten_V1(target.getList()));
            }
        }
        return res;
    }
    //非递归
    public List<Integer> flatten_V2(List<NestedInteger> nestedList){
        List<Integer> res = new ArrayList<Integer>();

        Queue<List<NestedInteger>> queue = new LinkedList<List<NestedInteger>>();
        queue.add(nestedList);
        while (queue.size()>0){
            List<NestedInteger> poll = queue.poll();
            for(NestedInteger nestedInteger : poll){
                if(nestedInteger.isInteger()){
                    res.add(nestedInteger.getInteger());
                }else {
                    queue.add(nestedInteger.getList());
                }
            }
        }
        return res;
    }
}
