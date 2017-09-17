package com.stark._1_100._51_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/9/15.
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 * 在三元组(a, b, c)，要求a <= b <= c。
 * 结果不能包含重复的三元组。
 */
public class LintCode_57 {
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbers);
        int len = numbers.length;
        a:for(int i=0;i<len-2;i++){
            if(i!=0){
                while (numbers[i]==numbers[i-1]){
                    i++;
                    if(i>=len-2){
                        break a;
                    }
                }
            }
            b:for(int j=i+1;j<len-1;j++){
                if(j!=i+1){
                    while (numbers[j]==numbers[j-1]){
                        j++;
                        if(j>=len-1){
                            break b;
                        }
                    }
                }
                c:for(int k=j+1;k<len;k++){
                    if(k!=j+1){
                        while (numbers[k]==numbers[k-1]){
                            k++;
                            if(k>=len){
                                break c;
                            }
                        }

                    }
                    if(numbers[i]+numbers[j]+numbers[k]==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
}
