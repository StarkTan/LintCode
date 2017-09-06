package com.stark._1_100._11_20;

import java.util.*;

/**
 * Created by Stark on 2017/9/6.
 * 扔 n 个骰子，向上面的数字之和为 S。
 * 给定 Given n，请列出所有可能的 S 值及其相应的概率。
 *
 */
public class LintCode_20 {
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        Map<Integer,Double> map = server(n);
        List<Map.Entry<Integer, Double>> res = new ArrayList<Map.Entry<Integer, Double>>();
        res.addAll(map.entrySet());
        return res;
    }

    private Map<Integer,Double> server(int n) {
        Map<Integer,Double> res = new TreeMap<Integer, Double>();
        if(n==0){
            res.put(0,1.0);
            return res;
        }else {
            Iterator<Map.Entry<Integer, Double>> iterator = server(n-1).entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, Double> next = iterator.next();
                Integer key = next.getKey();
                Double value = next.getValue();
                for(int i=1;i<=6;i++){
                    int newKey = key+i;
                    if(res.containsKey(newKey)){
                        res.put(newKey,res.get(newKey)+value*(1.0/6));
                    }else {
                        res.put(newKey,value*(1.0/6));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_20().dicesSum(1));
    }
}
