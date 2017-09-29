package com.stark._401_500;

/**
 * Created by Stark on 2017/9/29.
 * 攀爬字符串
 */
public class LintCode_430 {
    public boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1 == null || s2 == null)
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2)
            return false;
        if (s1.equals(s2))
            return true;
        if (len1 < 2) return false;
        for (int i = 0; i < len1 - 1; i++) {
            String org_left = s1.substring(0, i + 1);
            String org_right = s1.substring(i + 1, len1);
            String cha_left = s2.substring(0, i + 1);
            if (isScramble(org_left, cha_left)) {
                String cha_left_right = s2.substring(i + 1, len1);
                if (isScramble(org_right, cha_left_right)) {
                    return true;
                }
            }
            String cha_right = s2.substring(len1 - i - 1, len1);
            if (isScramble(org_left, cha_right)) {
                String cha_right_left = s2.substring(0, len1 - i - 1);
                if (isScramble(org_right, cha_right_left)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LintCode_430 test = new LintCode_430();
        boolean scramble = test.isScramble("rgthe", "gehrt");
        System.out.println(scramble);
    }
}
