package com.stark._101_200._191_200;

import java.util.Stack;

public class LintCode_193 {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int resMax = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<chars.length;i++){
            char ch = chars[i];
            if(ch=='('){
                stack.push(i);
            }else {
                if(!stack.empty()){
                    int peek = stack.peek();
                    if(peek==-1){
                        stack.pop();
                        stack.pop();
                    }
                    if(stack.empty()) continue;
                    int left = stack.pop();
                    int res = i-left+1;
                    if (!stack.empty()) {
                        peek = stack.peek();
                        if (peek == -1) {
                            stack.pop();
                            int last = stack.pop();
                            res = res + last;
                        }
                    }
                    stack.push(res);
                    stack.push(-1);
                    if(res>resMax) resMax=res;
                }
            }
        }
        return resMax;
    }

    public static void main(String[] args) {
        String s = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
        s ="((()))())";
        System.out.println(new LintCode_193().longestValidParentheses(s));

    }
}
