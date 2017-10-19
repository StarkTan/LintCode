package com.stark._101_200._131_140;

import java.util.*;

/**
 * Created by Stark on 2017/10/19.
 * Given N buildings in a x-axis，
 * each building is a rectangle and can be represented by a triple (start, end, height)，
 * where start is the start position on x-axis, e
 * nd is the end position on x-axis and height is the height of the building.
 * Buildings may overlap if you see them from far away，find the outline of them。
 * <p>
 * An outline can be represented by a triple, (start, end, height),
 * where start is the start position on x-axis of the outline,
 * end is the end position on x-axis and height is the height of the outline.
 */
public class LintCode_131 {
    //超時
    public List<List<Integer>> buildingOutline_V1(int[][] buildings) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        //检查x最远值
        int max = 0;
        for (int[] nums : buildings) {
            if (nums[1] > max) {
                max = nums[1];
            }
        }
        //构建新数组 长度为max 高度为出现最高
        int[] map = new int[max];
        //将大楼形状拆为宽度为1放入数组中
        for (int[] nums : buildings) {
            int height = nums[2];
            for (int i = nums[0]; i < nums[1]; i++) {
                if (height > map[i]) {
                    map[i] = height;
                }
            }
        }
        int begin = 0;
        //根据map来构建轮廓
        while (begin < max) {
            int curHeight = map[begin];
            int end = begin;
            while (true) {
                if (!(++end < max && map[end] == curHeight)) break;
            }
            if (curHeight != 0) {
                List<Integer> list = new ArrayList<>();
                list.add(begin);
                list.add(end);
                list.add(curHeight);
                res.add(list);
            }
            begin = end;
        }
        return res;
    }

    //内存不足
    public List<List<Integer>> buildingOutline_V2(int[][] buildings) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        //检查x最远值
        int max = 0;
        for (int[] nums : buildings) {
            if (nums[1] > max) {
                max = nums[1];
            }
        }
        //储存高度
        List<Integer> memory = new ArrayList<>();
        //构建新数组 长度为max+1 正反高度
        List<List<Integer>> map = new ArrayList<>(max);
        for (int i = 0; i <= max; i++) {
            map.add(new ArrayList<>());
        }
        //将大楼拆分左右墙
        for (int[] nums : buildings) {
            int height = nums[2];
            int left = nums[0];
            int right = nums[1];
            map.get(left).add(height);
            map.get(right).add(-height);
        }
        List<Integer> cache = new ArrayList<>();
        int begin = 0;
        int end = 0;
        while (begin < max) {
            List<Integer> list = map.get(begin);
            if (list.isEmpty()) {
                begin++;
                continue;
            } else {
                if (begin != end) {
                    for (Integer i : list) {
                        if (i > 0) {
                            cache.add(i);
                        } else {
                            cache.remove(new Integer(-i));
                        }
                    }
                }
            }
            int curHeight = getTop(cache)[0];
            if (curHeight == 0) {
                begin++;
                continue;
            }
            end = begin + 1;
            while (true) {
                List<Integer> list1 = map.get(end);
                int up = getTop(list1)[0];
                int down = getTop(list1)[1];
                if (!list1.isEmpty()) {
                    for (Integer i : list1) {
                        if (i < 0) {
                            cache.remove(new Integer(-i));
                        } else {
                            cache.add(i);
                        }
                    }
                }
                if (end >= max) break;
                if (curHeight < up) break;
                if (curHeight + down == 0 && !cache.contains(curHeight)) break;
                end++;
            }
            List<Integer> list1 = new ArrayList<>();
            list1.add(begin);
            list1.add(end);
            list1.add(curHeight);
            res.add(list1);
            begin = end;
        }
        return res;
    }

    //优化内存还是不足
    public List<List<Integer>> buildingOutline_V3(int[][] buildings) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (buildings.length == 0) {
            return res;
        }
        Map<Integer, Vector<Integer>> map = new TreeMap<>();
        for (int[] nums : buildings) {
            int height = nums[2];
            int left = nums[0];
            int right = nums[1];
            if (map.containsKey(left)) {
                map.get(left).add(height);
            } else {
                Vector<Integer> vector = new Vector<>();
                vector.add(height);
                map.put(left, vector);
            }
            if (map.containsKey(right)) {
                map.get(right).add(-height);
            } else {
                Vector<Integer> vector = new Vector<>();
                vector.add(-height);
                map.put(right, vector);
            }
        }
        //开始解析map
        Set<Integer> keyset = map.keySet();
        Iterator<Integer> keys = keyset.iterator();
        int begin = keys.next();
        List<Integer> cache = new ArrayList<>();
        cache.addAll(map.get(begin));
        int curHeight = getTop(cache)[0];
        while (keys.hasNext()) {
            Integer next = keys.next();
            List<Integer> nextList = map.get(next);
            int up = getTop(nextList)[0];
            int down = getTop(nextList)[1];
            for (Integer i : nextList) {
                if (i > 0) {
                    cache.add(i);
                } else {
                    cache.remove(new Integer(-i));
                }
            }
            if (up > curHeight || (curHeight == -down && !cache.contains(curHeight))) {
                List<Integer> list = new ArrayList<>();
                list.add(begin);
                list.add(next);
                list.add(curHeight);
                res.add(list);
            } else {
                continue;
            }
            if (cache.isEmpty() && keys.hasNext()) {
                begin = keys.next();
                curHeight = getTop(map.get(begin))[0];
            } else {
                begin = next;
                curHeight = getTop(cache)[0];
            }
        }
        return res;
    }

    private int[] getTop(List<Integer> memory) {
        int min = 0;
        int max = 0;
        for (Integer i : memory) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        return new int[]{max, min};
    }

    public List<List<Integer>> buildingOutline_V4(int[][] buildings) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        int len = buildings.length;
        if (len == 0) return res;
        int[][] map = new int[len * 2][2];
        for (int i = 0; i < len; i++) {
            map[i * 2][0] = buildings[i][0];
            map[i * 2][1] = buildings[i][2];
            map[i * 2 + 1][0] = buildings[i][1];
            map[i * 2 + 1][1] = -buildings[i][2];
        }
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        //保存没有结束的墙
        List<Integer> cache = new ArrayList<>();
        int begin = map[0][0];
        cache.add(map[0][1]);
        int height = getTop(cache)[0];
        for (int i = 1; i < len * 2; i++) {
            int curHeight = map[i][1];
            if (curHeight > 0) {
                cache.add(curHeight);
            } else {
                cache.remove(new Integer(-curHeight));
            }
            if (curHeight > height) { //遇到更高
                List<Integer> list = new ArrayList<>();
                list.add(begin);
                list.add(map[i][0]);
                list.add(height);
                res.add(list);
                begin = map[i][0];
                height = curHeight;
                continue;
            }
            if (curHeight + height == 0 && !cache.contains(height)) {
                List<Integer> list = new ArrayList<>();
                list.add(begin);
                list.add(map[i][0]);
                list.add(height);
                res.add(list);
                if (cache.isEmpty()) {
                    if (i + 1 < len * 2) {
                        begin = map[i + 1][0];
                        cache.add(map[i + 1][1]);
                        height = map[i + 1][1];
                        i++;
                    }
                } else {
                    begin = map[i][0];
                    height = getTop(cache)[0];
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LintCode_131 test = new LintCode_131();
        List<List<Integer>> lists = test.buildingOutline_V4(new int[][]{new int[]{1, 10, 3},
                new int[]{2, 5, 8}, new int[]{7, 9, 8}});
        System.out.println(lists);

    }
}
