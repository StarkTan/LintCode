package com.stark._1_100._51_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stark on 2017/9/15.
 * 给一个包含n个数的整数数组S，在S中找到所有使得和为给定整数target的四元组(a, b, c, d)。
 * 注意事项
 * 四元组(a, b, c, d)中，需要满足a <= b <= c <= d
 * 答案中不可以包含重复的四元组。
 */
public class LintCode_58 {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbers);
        int len = numbers.length;
        a:for(int i=0;i<len-3;i++){
            if(i!=0){
                while (numbers[i]==numbers[i-1]){
                    i++;
                    if(i>=len-3){
                        break a;
                    }
                }
            }
            b:for(int j=i+1;j<len-2;j++){
                if(j!=i+1){
                    while (numbers[j]==numbers[j-1]){
                        j++;
                        if(j>=len-2){
                            break b;
                        }
                    }
                }
                c:for(int k=j+1;k<len-1;k++){
                    if(k!=j+1){
                        while (numbers[k]==numbers[k-1]){
                            k++;
                            if(k>=len-1){
                                break c;
                            }
                        }
                    }
                    d:for(int p=k+1;p<len;p++){
                        if(p!=k+1){
                            while (numbers[p]==numbers[p-1]){
                                p++;
                                if(p>=len){
                                    break d;
                                }
                            }
                        }
                        if(numbers[i]+numbers[j]+numbers[k]+numbers[p]==target){
                            List<Integer> list = new ArrayList<>();
                            list.add(numbers[i]);
                            list.add(numbers[j]);
                            list.add(numbers[k]);
                            list.add(numbers[p]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }
}
