package com.stark._1_100;

/**
 * Created by Stark on 2017/8/28.
 * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 * <p>
 * 当某一位的数字小于i时，那么该位出现i的次数为：更高位数字x当前位数
 * 当某一位的数字等于i时，那么该位出现i的次数为：更高位数字x当前位数+低位数字+1
 * 当某一位的数字大于i时，那么该位出现i的次数为：(更高位数字+1)x当前位数
 */
public class LintCode_3 {
    public int digitCounts_v1(int k, int n) {
        // write your code here
        if(n==0&&k==0) return 1;
        int res = 0;
        int p = 1;//个位开始统计
        while (p <= n) {
            int u = n / (p * 10); //前面数
            int i = n % (p * 10);
            int c = i/p; //当前位
            int b = i%p; //后面位
            if(c<k) res = res + u*p;
            if(c==k) res = res+u*p+b+1;
            if(c>k){
                if(k==0&&u==0){

                }else{
                    res = res+ (u+1)*p;
                }
            }
            p = p * 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_3().digitCounts_v1(0, 19));
    }
}
