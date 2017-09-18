package com.stark._401_500._421_430;

import java.util.Stack;

/**
 * Created by Stark on 2017/9/17.
 * 给定一个字符串所表示的括号序列，
 * 包含以下字符： '(', ')', '{', '}', '[' and ']'， 判定是否是有效的括号序列。
 */
public class LintCode_423 {
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            if(c==')'){
                if(stack.pop()!='('){
                    return false;
                }
            }
            if(c=='}'){
                if(stack.pop()!='{'){
                    return false;
                }
            }
            if(c==']'){
                if(stack.pop()!='['){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
