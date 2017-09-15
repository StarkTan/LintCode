package com.stark._1_100._21_30;

import com.stark.entity.Interval;

import java.util.List;

/**
 * Created by Stark on 2017/9/8.
 * 给出一个无重叠的按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class LintCode_30 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.isEmpty()){
            intervals.add(newInterval);
            return intervals;
        }
        int pos =-1; //插入位置
        int num =0;//覆盖位置
        for(int i=0;i<intervals.size();i++){
            Interval ori = intervals.get(i);
            if(i==0){
                if(newInterval.end<ori.start){
                    intervals.add(0,newInterval);
                    return intervals;
                }
                if(newInterval.end==ori.start){
                    ori.start = newInterval.start;
                    return intervals;
                }
            }
            if(newInterval.end<ori.start){
                pos = pos==-1?i:pos;
                break;
            }
            if(newInterval.start<=ori.end){
                newInterval.start = Math.min(newInterval.start,ori.start);
                newInterval.end = Math.max(newInterval.end,ori.end);
                pos = pos==-1?i:pos;
                num++;
            }
        }
        if(pos==-1) {
            intervals.add(newInterval);
        }else {
            intervals.add(pos,newInterval);
            for(int i=1;i<=num;i++){
                intervals.remove(pos+1);
            }
        }
        return intervals;
    }
}
