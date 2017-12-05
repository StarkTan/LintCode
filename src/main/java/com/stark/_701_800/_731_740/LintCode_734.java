package com.stark._701_800._731_740;

/**
 * Created by Stark on 2017/12/5.
 * 给一字符串, 对形式为 a^i b^j c^k 的子序列进行计数, 即它由 i 个字符 a,
 * 接着是 j 个字符 b, 然后是 k 个字符 c组成, i >= 1, j >= 1, k >= 1.
 * Note: 如果两个子序列在原字符串中的index集合是不同的，则认为两个子序列不同。
 */
public class LintCode_734 {
    public int countSubsequences(String source) {
        // write your code here
        int end = source.length() - 1;
        int res = 0;
        for (int i = 0; i < end - 1; i++) {
            if (source.charAt(i) == 'a') res += solve(source, i + 1, end, 'a');
        }
        return res;
    }

    private int solve(String source, int begin, int end, char pre) {
        int res = 0;
        for (int i = begin; i <= end; i++) {
            char c = source.charAt(i);
            if (c == 'a') {
                if (pre == 'a') res += solve(source, i + 1, end, 'a');
            }
            if (c == 'b') {
                if (pre == 'a' || pre == 'b') res += solve(source, i + 1, end, 'b');
            }
            if (c == 'c') {
                if (pre == 'c' || pre == 'b') {
                    res++;
                    res += solve(source, i + 1, end, 'c');
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_734().countSubsequences("abcc"));
    }
}
