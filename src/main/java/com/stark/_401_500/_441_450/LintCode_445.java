package com.stark._401_500._441_450;

/**
 * Created by Stark on 2017/11/17.
 * Cosine Similarity
 */
public class LintCode_445 {
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        int sum1 = 0;
        int sum2 = 0;
        int total = 0;
        for (int i = 0; i < A.length && i < B.length; i++) {
            sum1 += A[i] * A[i];
            sum2 += B[i] * B[i];
            total += A[i] * B[i];
        }
        if (sum1 == 0 || sum2 == 0) {
            return 2.0;
        }
        return total / (Math.sqrt(sum1) * Math.sqrt(sum2));
    }

    public static void main(String[] args) {
        LintCode_445 test = new LintCode_445();
        double v = test.cosineSimilarity(new int[]{1, 2, 3}, new int[]{2, 3, 4});
        System.out.println(v);
    }
}
