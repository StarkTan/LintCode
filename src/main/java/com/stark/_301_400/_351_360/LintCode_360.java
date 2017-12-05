package com.stark._301_400._351_360;

import com.stark.entity.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Stark on 2017/12/4.
 */
public class LintCode_360 {
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        //两个堆，一个最大堆，一个最小
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 让maxHeap始终保存小于一半的值，minHeap保存大于一半的，正好两半
            if (maxHeap.size() == 0 || maxHeap.peek() >= num)
                maxHeap.add(num);
            else minHeap.add(num);
            // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
            if (minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            // 如果需要输出
            if (i - k + 1 >= 0) {
                res.add(maxHeap.peek());
                int cur = nums[i - k + 1];
                if (minHeap.contains(cur)) minHeap.remove(cur);
                else maxHeap.remove(cur);
                if (minHeap.size() > maxHeap.size())
                    maxHeap.add(minHeap.poll());
                if (maxHeap.size() > minHeap.size() + 1)
                    minHeap.add(maxHeap.poll());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_360 lintCode_360 = new LintCode_360();
        List<Integer> list = lintCode_360.medianSlidingWindow(new int[]{1, 2, 7, 8, 5}, 3);
        System.out.println(list);
    }
}
