package com.stark._401_500._451_460;

/**
 * Created by Stark on 2017/9/17.
 * 实现一个矩阵类Rectangle，包含如下的一些成员变量与函数：
 * 两个共有的成员变量 width 和 height 分别代表宽度和高度。
 * 一个构造函数，接受2个参数 width 和 height 来设定矩阵的宽度和高度。
 * 一个成员函数 getArea，返回这个矩阵的面积。
 */
public class LintCode_454 {
    public int width;
    public int height;
    public LintCode_454(int width,int height){
        this.width = width;
        this.height = height;
    }
    public int getArea(){
        return width*height;
    }
}
