package com.stark._601_700._611_620;

import java.util.*;

/**
 * Created by Stark on 2017/9/17.
 * 你需要去上n门九章的课才能获得offer，这些课被标号为 0 到 n-1 。
 * 有一些课程需要“前置课程”，比如如果你要上课程0，你需要先学课程1，我们用一个匹配来表示他们： [0,1]
 * 给你课程的总数量和一些前置课程的需求，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */
public class LintCode_616 {
    //测试正确，无法提交oj
    /*public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        List<Integer> list = new ArrayList<>();
        int len = prerequisites.length;

        for (int i = 0; i < numCourses; i++) {
            list.add(i);
        }
        while (!list.isEmpty()) {
            boolean move = false;
            a: for (int i = 0; i < list.size(); i++) {
                int cur = list.get(i);
                for (int j = 0; j < len; j++) {
                    if (prerequisites[j][0] == cur) {
                        continue a;
                    }
                }
                for (int j = 0; j < len; j++) {
                    if (prerequisites[j][1] == cur) {
                        prerequisites[j][0] = numCourses;
                    }
                }
                res[numCourses-list.size()] = cur;
                list.remove(i);
                move = true;
                break ;
            }
            if(!move){
                return new int[]{};
            }
        }
        return res;
    }*/
    //网上解法
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        ArrayList<HashSet<Integer>> record = new ArrayList<HashSet<Integer>>();
        for(int i = 0;i<numCourses;i++){
            record.add(new HashSet<Integer>());
        }

        for(int i = 0;i<prerequisites.length;i++){
            record.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] numPre = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            for(int after : record.get(i)){
                numPre[after]++;
            }
        }

        Queue<Integer> sortCourse = new LinkedList<Integer>();
        for(int i = 0;i<numCourses;i++){
            if(numPre[i] == 0){
                sortCourse.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int count = 0;
        while(!sortCourse.isEmpty()){
            int current = sortCourse.poll();
            for(int after : record.get(current)){
                numPre[after]--;
                if(numPre[after] == 0){
                    sortCourse.offer(after);
                }
            }
            result[count++] = current;
        }
        return count == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        LintCode_616 lintCode_616 = new LintCode_616();
        int[][] xx= new int[2][2];
        xx[0] = new int[]{1,0};
        xx[1] = new int[]{2,1};
        int[] order = lintCode_616.findOrder(3, xx);
        System.out.println(order);
    }
}
