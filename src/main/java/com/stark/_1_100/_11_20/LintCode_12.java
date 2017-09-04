package com.stark._1_100._11_20;

import java.util.Stack;

/**
 * Created by Stark on 2017/9/3.
 * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
 * 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
 */
public class LintCode_12 {

    //使用一个辅助栈来存放最小值
    private Stack<Integer> stack;
    private Stack<Integer> stackMin;
    public LintCode_12() {
        stack = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if(stackMin.isEmpty()||stackMin.peek()>number){
            stackMin.push(number);
        }else{
            stackMin.push(stackMin.peek());
        }
    }

    public int pop() {
        stackMin.pop();
        return stack.pop();
    }

    public int min() {
        return stackMin.peek();
    }
}
