package com.stark._101_200._171_180;

/**
 * Created by Stark on 2017/10/20.
 * 给定一个数将其转换为二进制（均用字符串表示），
 * 如果这个数的小数部分不能在 32 个字符之内来精确地表示，则返回 "ERROR"。
 */
public class LintCode_180 {
    public String binaryRepresentation(String n) {
        if (n == null || n == "" || n.charAt(0) == '-') {
            return "ERROR";
        }
        try {
            String result = "";
            result = Integer.toBinaryString(
                    Integer.parseInt(n.split("\\.")[0])
            ) + ".";
            double target = Double.parseDouble(
                    "0." + n.split("\\.")[1]
            );
            String result1 = "";
            while (result1.length() <= 32 && target - 0 > 1e-10) {
                target = target * 2;
                if (target >= 1) {
                    result1 += "1";
                    target -= 1;
                } else {
                    result1 += "0";
                }
            }
            result += result1;
            if (result1.length() <= 32) {
                return (result.split("\\.").length > 1) ? result : result.split("\\.")[0];
            }
            return "ERROR";
        } catch (Exception e) {
            return "ERROR";
        }
    }

    public static void main(String[] args) {

    }

}
