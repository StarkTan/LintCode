package com.stark._101_200._121_130;

import java.math.BigDecimal;

/**
 * Created by Stark on 2017/10/2.
 * 在数据结构中，哈希函数是用来将一个字符串（或任何其他类型）转化为小于哈希表大小且大于等于零的整数。
 * 一个好的哈希函数可以尽可能少地产生冲突。一种广泛使用的哈希函数算法是使用数值33
 * 给出一个字符串作为key和一个哈希表的大小，返回这个字符串的哈希值
 */
public class LintCode_128 {

    //超时没有被AC ，使用python完成
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        int len = key.length;
        BigDecimal pow = new BigDecimal(1);
        BigDecimal multiply = new BigDecimal(key[len-1]);
        for (int i = len-2; i >=0; i--) {
            char c = key[i];
            pow = pow.multiply(new BigDecimal(33));
            BigDecimal multiply1 = pow.multiply(new BigDecimal(c));
            multiply = multiply.add(multiply1);
        }
        return multiply.divideAndRemainder(new BigDecimal(HASH_SIZE))[1].intValue();
    }


    public static void main(String[] args) {
        LintCode_128 test = new LintCode_128();
        int i = test.hashCode(new char[]{'a', 'b', 'c','d'}, 1000);
        BigDecimal bigDecimal = new BigDecimal('a');
        System.out.println('a'-bigDecimal.intValue());
        System.out.println(i);
    }
}
