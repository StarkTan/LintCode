package com.stark._101_200._181_190;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Stark on 2017/12/5.
 */
public class LintCode_182 {
    public String DeleteDigits(String A, int l) {
        // write your code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            while (l > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                l--;
            }
            stack.push(c);
        }
        while (l > 0 && !stack.isEmpty()) {
            stack.pop();
            l--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.indexOf("0") == 0 && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
