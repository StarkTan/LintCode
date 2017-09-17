package com.stark._601_700._611_620;

import com.stark.entity.Point;

/**
 * Created by Stark on 2017/9/17.
 * 给定一些 points 和一个 origin，从 points 中找到 k 个离 origin 最近的点。
 * 按照距离由小到大返回。如果两个点有相同距离，则按照x值来排序；若x值也相同，就再按照y值排序。
 */
public class LintCode_612 {
    public Point[] kClosest(Point[] points, Point origin, int k) {
        Point temp = null;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j <= points.length - 1; j++) {
                if (farther(points[i],points[j],origin)) {// 注意和冒泡排序的区别，这里是i和j比较。
                    temp = points[i];
                    points[i] = points[j];
                    points[j] = temp;
                }
            }
        }
        Point[] result = new Point[k];
        for(int i=0;i<k;i++){
            result[i] = points[i];
        }
        return result;
    }

    //比较器
    public static boolean farther(Point one, Point two,Point origin){
        int distance1 = (one.x-origin.x)*(one.x-origin.x)+(one.y-origin.y)*(one.y-origin.y);
        int distance2 = (two.x-origin.x)*(two.x-origin.x)+(two.y-origin.y)*(two.y-origin.y);
        if(distance1>distance2) return true;
        if(distance1<distance2) return false;
        if(one.x>two.x) return true;
        if(one.x<two.x) return false;
        if(one.y>two.y) return true;
        if(one.y<two.y) return false;
        return true;
    }
}
