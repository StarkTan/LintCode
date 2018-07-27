package com.stark._101_200._141_150;

/**
 * 将一个字符由小写字母转换为大写字母
 */
public class LintCode_145 {
    public char lowercaseToUppercase(char character) {
        // write your code here
        character = (char) (character -32);
        return character;
    }
}
