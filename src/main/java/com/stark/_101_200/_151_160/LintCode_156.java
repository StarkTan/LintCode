package com.stark._101_200._151_160;

import com.stark.entity.Interval;

import java.util.List;

/**
 * Created by Stark on 2017/10/10.
 * 给出若干闭合区间，合并所有重叠的部分。
 */
public class LintCode_156 {
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals.size() <= 1) {
            return intervals;
        }
        //进行排序
        for(int i=0;i<intervals.size()-1;i++){
            Interval min = intervals.get(i);
            for(int j=i+1;j<intervals.size();j++){
                if(intervals.get(j).start<min.start){
                    min = intervals.get(j);
                }
            }
            intervals.remove(min);
            intervals.add(i,min);
        }
        //前面有几个
        int head = 0;
        while (head < intervals.size() - 1) {
            Interval one = intervals.get(head);
            Interval two = intervals.get(head + 1);
            if(one.end>=two.start){
                Interval newIn = new Interval(Math.min(one.start,two.start),Math.max(one.end,two.end));
                intervals.remove(one);
                intervals.remove(two);
                intervals.add(head,newIn);
            }else {
                head++;
            }
        }
        return intervals;
    }
}
