package com.stark._601_700._611_620;

import java.util.*;

/**
 * Created by Stark on 2017/9/20.
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */
public class LintCode_615 {

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        //解析prerequisites
        List<Set<Integer>> record = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            record.add(new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            record.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] numPre = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int after : record.get(i)) {
                numPre[after]++;
            }
        }

        Queue<Integer> sortCourse = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (numPre[i] == 0) {
                sortCourse.offer(i);
            }
        }
        int count = 0;
        while (!sortCourse.isEmpty()) {
            int current = sortCourse.poll();
            for (int after : record.get(current)) {
                numPre[after]--;
                if (numPre[after] == 0) {
                    sortCourse.offer(after);
                }
            }
        }
        count++;
        return count == numCourses;
    }
}
