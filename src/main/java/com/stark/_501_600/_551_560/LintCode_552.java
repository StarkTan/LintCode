package com.stark._501_600._551_560;

import java.util.Arrays;

/**
 * Created by Stark on 2017/11/16.
 * 给出两个长度分别是m和n的数组来表示两个大整数，数组的每个元素都是数字0-9。
 * 从这两个数组当中选出k个数字来创建一个最大数，其中k满足k <= m + n。
 * 选出来的数字在创建的最大数里面的位置必须和在原数组内的相对位置一致。
 * 返回k个数的数组。你应该尽可能的去优化算法的时间复杂度和空间复杂度。
 * <p>
 * <p>
 * TODO 实在在大量级搞不好了
 */
public class LintCode_552 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // write your code here
        int[] res = new int[k];
        for (int i = 0; i <= k; i++) {
            if (i > nums1.length || k - i > nums2.length) continue;
            int[] big1 = bigArr(nums1, i);
            int[] big2 = bigArr(nums2, k - i);
            //将这两个数据进行整合
            int p = 0;
            int q = 0;
            int cur = 0;
            boolean bigger = false;
            while (p < big1.length || q < big2.length) {
                int curNum;
                if (p < big1.length && q < big2.length) {
                    if (big1[p] > big2[q]) {
                        curNum = big1[p++];
                    } else if (big1[p] < big2[q]) {
                        curNum = big2[q++];
                    } else {
                        curNum = big2[q];
                        int p1 = p;
                        int q1 = q;
                        while (p1 < big1.length && q1 < big2.length && big1[p1] == big2[q1]) {
                            p1++;
                            q1++;
                        }
                        if (p1 < big1.length && q1 < big2.length) {
                            if (big1[p1] > big2[q1]) p++;
                            else q++;
                        } else {
                            //TODO 需要逻辑优化或者其他处理
                            if (p1 == big1.length && q1 == big2.length) q++;
                            else if (p1 == big1.length && big2[q1] > curNum) q++;
                            else if (q1 == big2.length && big1[p1] > curNum) p++;
                            else q++;
                        }
                    }
                } else if (p < big1.length) {
                    curNum = big1[p++];
                } else {
                    curNum = big2[q++];
                }

                if (res[cur] > curNum && !bigger) break;
                else if (res[cur] == curNum) {
                    cur++;
                } else {
                    bigger = true;
                    System.out.println(Arrays.toString(big1));
                    System.out.println(Arrays.toString(big2));
                    res[cur] = curNum;
                    cur++;
                }
            }
        }
        return res;
    }

    private int[] bigArr(int[] nums, int k) {
        if (k == 0) return new int[0];
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = -1;
        }
        int left = nums.length - k;
        res[0] = nums[0];
        int pos = 1;
        for (int cur = 1; cur < nums.length; cur++) {
            while (left > 0 && pos > 0 && nums[cur] > res[pos - 1]) {
                res[pos - 1] = -1;
                pos--;
                left--;
            }
            if (pos >= k) {
                left--;
                continue;
            }
            res[pos] = nums[cur];
            pos++;
        }
        return res;
    }

    public static void main(String[] args) {
        LintCode_552 test = new LintCode_552();
        int[] ints = test.maxNumber(new int[]{7, 8, 5, 8, 0, 1, 1, 6, 1, 7, 6, 9, 6, 6, 0, 8, 5, 8, 6, 3, 4, 0, 4, 6, 7, 8, 7, 7, 7, 5, 7, 2, 5, 2, 1, 9, 5, 9, 3, 7, 3, 9, 9, 3, 1, 4, 3, 3, 9, 7, 1, 4, 4, 1, 4, 0, 2, 3, 1, 3, 2, 0, 2, 4, 0, 9, 2, 0, 1, 3, 9, 1, 2, 2, 6, 6, 9, 3, 6, 0
                }, new int[]{1, 5, 8, 1, 4, 0, 8, 5, 0, 7, 0, 5, 7, 6, 0, 5, 5, 2, 4, 3, 6, 4, 6, 6, 3, 8, 1, 1, 3, 1, 3, 5, 4, 3, 9, 5, 0, 3, 8, 1, 4, 9, 8, 8, 3, 4, 6, 2, 5, 4, 1, 1, 4, 6, 5, 2, 3, 6, 3, 5, 4, 3, 0, 7, 2, 5, 1, 5, 3, 3, 8, 2, 2, 7, 6, 7, 5, 9, 1, 2},
                80);
        System.out.println(Arrays.toString(ints));
    }
}
