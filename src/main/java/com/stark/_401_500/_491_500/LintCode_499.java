package com.stark._401_500._491_500;

import com.stark.entity.OutputCollector;

import java.util.Iterator;

/**
 * Created by Stark on 2017/9/17.
 * 使用 map reduce 来计算单词频率
 * https://hadoop.apache.org/docs/r1.2.1/mapred_tutorial.html#Example%3A+WordCount+v1
 */
public class LintCode_499 {
    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            String[] tmp = value.split(" ");
            for(int i = 0;i < tmp.length;i++){
                output.collect(tmp[i],1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            int count = 0;
            while(values.hasNext()){
                count += values.next();
            }
            output.collect(key , count);
        }
    }
}
