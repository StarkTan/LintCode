package com.stark._601_700._691_700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Stark on 2017/12/6.
 * TODO 失败
 */
public class LintCode_696 {
    public int scheduleCourse(int[][] courses) {
        // write your code here
        int count = 0;
        List<Courses> coursesList = new ArrayList<>();
        for (int[] course : courses) {
            if (course[1] < course[0]) continue;
            coursesList.add(new Courses(course));
        }
        while (!coursesList.isEmpty()) {
            int most = 0;
            int index = 0;
            for (int i = 0; i < coursesList.size(); i++) {
                Courses cur = coursesList.get(i);
                int t = 0;
                for (Courses course : coursesList) {
                    if (cur == course) continue;
                    if (cur.day + course.day <= course.deadline) t++;
                }
                if (t > most) {
                    index = i;
                    most = t;
                }
            }
            count++;
            Courses courses1 = coursesList.get(index);
            coursesList.remove(index);
            List<Courses> coursesListnext = new ArrayList<>();
            for (Courses course : coursesList) {
                course.deadline = course.deadline - courses1.day;
                if (course.deadline >= course.day) coursesListnext.add(course);
            }
            coursesList = coursesListnext;
        }
        return count;
    }

    public static void main(String[] args) {
        new LintCode_696().scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}});
    }

    /*错误
    public int scheduleCourse(int[][] courses) {
        // write your code here
        int time = 0;
        int count = 0;
        List<Courses> coursesList = new ArrayList<>();
        for (int[] course : courses) {
            if (course[1] < course[0]) continue;
            coursesList.add(new Courses(course));
        }
        while (!coursesList.isEmpty()) {
            int nextTime = Integer.MAX_VALUE;
            int next = 0;
            for (int i = 0; i < coursesList.size(); i++) {
                Courses cur = coursesList.get(i);
                if (time > cur.deadline || time + cur.day > cur.deadline) {
                    coursesList.remove(i);
                    i--;
                    continue;
                }
                if (time + cur.day <= nextTime) {
                    next = i;
                    nextTime = time + cur.day;
                }
            }
            if (nextTime != Integer.MAX_VALUE)
                count++;
            if (!coursesList.isEmpty()) coursesList.remove(next);
            time = nextTime;
        }
        return count;
    }*/


//    public int scheduleCourse(int[][] courses) {
//        // write your code here
//        int time = 0;
//        int count = 0;
//        List<Courses> coursesList = new ArrayList<>();
//        for (int[] course : courses) {
//            if (course[1] < course[0]) continue;
//            coursesList.add(new Courses(course));
//        }
//        return solve(coursesList, time);
//    }
//
//    private int solve(List<Courses> coursesList, int time) {
//        List<Courses> courses = new ArrayList<>();
//        for (Courses course : coursesList) {
//            if (course.day + time > course.deadline) continue;
//            courses.add(course);
//        }
//        if (courses.isEmpty()) return 0;
//        int res = 0;
//        for (int i = 0; i < courses.size(); i++) {
//            Courses cur = courses.get(i);
//            courses.remove(i);
//            int solve = solve(courses, cur.day + time);
//            if (solve + 1 > res) res = solve + 1;
//            courses.add(i, cur);
//        }
//        return res;
//    }

    class Courses {
        public Courses(int[] course) {
            this.day = course[0];
            this.deadline = course[1];
        }

        public int day;
        public int deadline;
    }
}
