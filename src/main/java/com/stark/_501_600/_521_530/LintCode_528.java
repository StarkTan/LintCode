package com.stark._501_600._521_530;

import com.stark.entity.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Stark on 2017/10/2.
 * 给你一个嵌套的列表，实现一个迭代器将其摊平。
 * 一个列表的每个元素可能是整数或者一个列表。
 */
public class LintCode_528  implements Iterator<Integer> {

    List<NestedInteger> nestedList = null;
    List<Integer> list = null;
    Iterator<Integer> iterator =null;

    public LintCode_528(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        this.nestedList =nestedList;
        list = new ArrayList<>();
        iterator(list,nestedList);
        iterator = list.iterator();
    }

    private void iterator(List<Integer> list, List<NestedInteger> nestedList) {

        for(NestedInteger item : nestedList){
            if(item.isInteger()){
                list.add(item.getInteger());
            }else {
                iterator(list,item.getList());
            }
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        return this.iterator.next();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        return this.iterator.hasNext();
    }

    @Override
    public void remove() {}
}
