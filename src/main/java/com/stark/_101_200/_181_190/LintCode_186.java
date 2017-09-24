package com.stark._101_200._181_190;

import com.stark.entity.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stark on 2017/9/22.
 * 给出二维平面上的n个点，求最多有多少点在同一条直线上。
 */
public class LintCode_186 {

    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        int length = points.length;
        if (length < 3) {
            return length;
        }
        int res = 2;
        for (int i = 0; i < length - 2; i++) {
            int inum = 1;
            a:
            for (int j = i + 1; j < length; j++) {
                int[] exp = getExpression(points[i], points[j]);
                if(exp[0]==0&&exp[1]==0&&exp[2]==0){
                    inum++;
                    res = Math.max(res, inum);
                    continue;
                }
                int cur = inum+1;
                for (int p = 0; p < i; p++) {
                    if (macth(exp, points[p])) continue a;
                }
                for (int k = j + 1; k < length; k++) {
                    if (macth(exp, points[k])) cur++;
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    private int[] getExpression(Point one, Point two) {
        int[] res = new int[3];
        res[0] = one.y - two.y;
        res[1] = two.x - one.x;
        res[2] = -one.x * res[0] - one.y * res[1];
        return res;
    }

    private boolean macth(int[] exp, Point point) {
        return point.x * exp[0] + point.y * exp[1] + exp[2] == 0;
    }


    public static void main(String[] args) {
        LintCode_186 test = new LintCode_186();
        System.out.println(test.maxPoints(new Point[]{new Point(1, 1), new Point(0, 0),
                new Point(-1, 0), new Point(0, 1), new Point(1, 2), new Point(2, 3),
                new Point(-1,0)}));
    }
}
