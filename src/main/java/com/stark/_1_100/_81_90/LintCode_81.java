package com.stark._1_100._81_90;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Stark on 2017/12/6.
 */
public class LintCode_81 {
    public int[] medianII(int[] nums) {
        // write your code here
        int len = nums.length;
        int[] res = new int[len];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(len, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(len);
        for (int i = 0; i < len; i++) {
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
            res[i] = maxHeap.peek();
        }
        return res;
    }
}
