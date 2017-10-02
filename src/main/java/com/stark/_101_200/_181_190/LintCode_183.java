package com.stark._101_200._181_190;

/**
 * Created by Stark on 2017/10/2.
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。
 * 当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。
 */
public class LintCode_183 {
    public int woodCut(int[] L, int k) {
        // write your code here
        int max = 0;
        for (int num : L) {
            max = Math.max(max, num);
        }
        int begin = 0;
        int end = max;
        int mid = 0;
        while (begin < end) {
            mid = begin / 2 + end / 2;
            if (begin % 2 == 0 && end % 2 == 0) mid++;
            if (mid == 0) {
                break;
            }
            int total = 0;
            for (int num : L) {
                total += num / mid;
            }
            if (total < k) {
                end = mid - 1;
                mid = end;
            } else {
                begin = mid + 1;
            }
        }
        int total=0;
        for (int num : L) {
            total += num / (mid+1);
        }
        if (total < k) {
            return mid;
        } else {
            return mid+1;
        }
    }
    public static void main(String[] args) {
        LintCode_183 test = new LintCode_183();
        int i = test.woodCut(new int[]{2147483644, 2147483645, 2147483646, 2147483647}, 4);
        System.out.println(i);
    }
}
