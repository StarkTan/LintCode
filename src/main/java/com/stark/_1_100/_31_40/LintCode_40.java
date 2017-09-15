package com.stark._1_100._31_40;

import java.util.Stack;

/**
 * Created by Stark on 2017/9/14.
 * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
 * pop和top方法都应该返回第一个元素的值。
 */
public class LintCode_40 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public LintCode_40() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.push(element);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        return stack1.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        return stack1.peek();
    }

    public static void main(String[] args) {
        LintCode_40 stack = new LintCode_40();
        stack.push(1);
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);stack.pop();
        System.out.println(stack.top());

    }
}
