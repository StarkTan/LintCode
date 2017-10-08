package com.stark._601_700._681_690;

/**
 * Created by Stark on 2017/10/3.
 * Given a number n, return the factorial of the number as a string.
 */
public class LintCode_690 {

    public String factorial(int n) {
        // write your code her
        int[] res = new int[]{1};
        for (int i = 1; i <= n; i++) {
            char[] curs = (i + "").toCharArray();
            int len1 = res.length;
            int len2 = curs.length;
            int len3;
            if (res[0] == 0) {
                len3 = len1 + len2 - 1;
            } else {
                len3 = len1 + len2;
            }
            int[] temp = new int[len3];
            for (int j = 0; j < len1; j++) {
                int cur1 = res[len1 - 1 - j];
                for (int k = 0; k < len2; k++) {
                    int cur2 = curs[len2 - 1 - k] - '0';
                    temp[len3 - 1 - j - k] += cur1 * cur2;
                }
            }
            for (int j = 0; j < len3; j++) {
                if (temp[len3 - 1 - j] >= 10) {
                    temp[len3 - 2 - j] += temp[len3 - 1 - j] / 10;
                    temp[len3 - 1 - j] = temp[len3 - 1 - j] % 10;
                }

            }
            res = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int c : res) {
            if (sb.length() != 0 || c != 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LintCode_690 test = new LintCode_690();
        int res = 1;
        for (int i = 1; i <= 12; i++) {
            res = res * i;
            System.out.println(i);
            System.out.println(res);
            System.out.println(test.factorial(i));
        }
    }
}
