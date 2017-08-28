package com.stark._1_100;

/**
 * Created by Stark on 2017/8/28.
 * #设计一个算法，计算出n阶乘数中尾部零的个数
 */
public class LintCode_2 {

    /**
     * 在完成阶乘之后的数目过大,溢出
     */
    public long trailingZeros_V1(long n) {
        if(n==0L) return 0L;
        long num = 1L;
        long result = 0;
        for(long i=1L;i<=n;i++){
            num = num*i;
        }
        //溢出num会为0
        while(num%10 == 0&&num>0){
            result++;
            num = num/10;
        }
        return result;
    }

    /**
     * 对每一个能被5除尽的数进行处理，有一个5作为因子，则末尾有一个零
     * 时间复杂度为O(n),空间复杂度O（1）
     */
    public long trailingZeros_V2(long n) {
        if(n==0L) return 0L;
        long result = 0;
        for(long i=5L;i<=n;i=i+5){
            Long num = i;
            while(num%5==0){
                num = num/5;
                result++;
            }
        }
        return result;
    }

    /**
     * 对V2的优化，不进行遍历，直接获取含5的因子个数,时间复杂度更低
     */
    public long trailingZeros_V3(long n) {
        if(n==0L) return 0L;
        long result = 0;
        long num = 5;
        while(n>num){
            result = result + n/num;
            num = num*5;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_2().trailingZeros_V3(5555550000000L));
    }
}
