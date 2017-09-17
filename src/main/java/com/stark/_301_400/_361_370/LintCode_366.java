package com.stark._301_400._361_370;

/**
 * Created by Stark on 2017/9/17.
 */
public class LintCode_366 {
    /*超时
       public int fibonacci(int n) {
           if(n==0){
               return 0;
           }
           if(n==1){
               return 0;
           }
           if(n==2){
               return 1;
           }
           return fibonacci(n-1)+fibonacci(n-2);
       }*/
    public int fibonacci(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        if (n > 0)
            arr[1] = 0;
        if (n > 1)
            arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
