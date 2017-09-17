package com.stark._101_200._121_130;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Stark on 2017/9/17.
 * 给出两个单词（start和end）和一个字典，找出所有从start到end的最短转换序列
 * 每次只能改变一个字母。
 * 变换过程中的中间单词必须在字典中出现。
 * 所有单词具有相同的长度。
 * 所有单词都只包含小写字母。
 */
public class LintCode_121 {
    //递归解决
    public List<List<String>> findLadders_V1(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(start);
        lists.add(list);
        if(start.equals(end)){
            return lists;
        }
        if (match(start, end)) {
            list.add(end);
            return lists;
        }
        return solve(lists, end, dict);
    }
    private List<List<String>> solve(List<List<String>> lists, String end, Set<String> dict) {
        if(lists.isEmpty())return lists;
        List<List<String>> newLists = new ArrayList<>();
        List<List<String>> returnLists = new ArrayList<>();
        boolean stop = false;
        Set<String> used = new HashSet<String>();
        for (List<String> list : lists) {
            String cur = list.get(list.size() - 1);
            for (String com : dict) {
                if (match(cur, com)) {
                    List<String> newlist = new ArrayList<>();
                    newlist.addAll(list);
                    newlist.add(com);
                    newLists.add(newlist);
                    if(stop){
                        if(match(end, com)){
                            newlist.add(end);
                            returnLists.add(newlist);
                        }
                    }else {
                        if(match(end, com)){
                            stop =true;
                            newlist.add(end);
                            returnLists.add(newlist);
                        }else {
                            used.add(com);
                        }
                    }
                }
            }
        }
        if(stop){
            return returnLists;
        }else {
            for(String str:used){
                dict.remove(str);
            }
            return solve(newLists,end,dict);
        }
    }

    //使用回溯法超时
    public List<List<String>> findLadders_V2(String start, String end, Set<String> dict) {
        List<List<String>> lists = new ArrayList<>();
        if (match(start, end)) {
            List<String> list = new ArrayList<>();
            list.add(start);
            list.add(end);
            lists.add(list);
            return lists;
        }
        //将set转为list
        List<String> dictList = new ArrayList<>();
        Iterator<String> iterator = dict.iterator();
        while (iterator.hasNext()) {
            dictList.add(iterator.next());
        }
        int len = dictList.size();
        int[] map = new int[len];
        int stepMin = Integer.MAX_VALUE;
        int step = 0;
        while (map[0] < len) {
            if (map[step] >= len || step > stepMin) {
                step--;
                map[step]++;
                continue;
            }
            boolean confir = confirBefore(map, step, dictList, start);
            if (confir) {
                boolean conEnd = confirEnd(map, step, dictList, end);
                if (conEnd) {

                    List<String> list = new ArrayList<>();
                    list.add(start);
                    for (int i = 0; i <= step; i++) {
                        list.add(dictList.get(map[i]));
                    }
                    list.add(end);
                    stepMin = Math.min(step, stepMin);
                    lists.add(list);
                    map[step]++;
                } else {
                    step++;
                    map[step] = 0;
                }
            } else {
                map[step]++;
            }
        }
        getShortest(lists);
        return lists;
    }

    //mao构建超时
    public List<List<String>> findLadders_V3(String start, String end, Set<String> dict) {
        //构建map
        Map<String, List<String>> map = new HashMap<>();
        List<String> dictList = new ArrayList<>();
        dict.add(start);
        Iterator<String> iterator = dict.iterator();
        while (iterator.hasNext()) {
            dictList.add(iterator.next());
        }
        for (int i = 0; i < dictList.size(); i++) {
            String one = dictList.get(i);
            for (int j = i + 1; j < dictList.size(); j++) {
                String two = dictList.get(j);
                if (match(one, two)) {
                    if (map.containsKey(one)) {
                        map.get(one).add(two);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(two);
                        map.put(one, list);
                    }

                    if (map.containsKey(two)) {
                        map.get(two).add(one);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(one);
                        map.put(two, list);
                    }

                }
            }
        }
        Queue<List<String>> current = new LinkedList<>();
        Queue<List<String>> next = new LinkedList<>();
        List<String> first = new ArrayList<>();
        first.add(start);
        current.add(first);
        boolean stop = false;
        List<List<String>> result = new ArrayList<>();
        while (!stop) {
            while (!current.isEmpty()) {
                List<String> cur = current.poll();
                String trail = cur.get(cur.size() - 1);
                boolean match = match(trail, end);
                if (stop) {
                    if (match) {
                        cur.add(end);
                        result.add(cur);
                    }
                } else {
                    if (match) {
                        stop = true;
                        cur.add(end);
                        result.add(cur);
                    } else {
                        //使用map
                        List<String> list = map.get(trail);
                        if (list != null) {
                            for (String s : list) {
                                List<String> newList = new ArrayList<>();
                                newList.addAll(cur);
                                if (!newList.contains(s)) {
                                    newList.add(s);
                                    next.add(newList);
                                }
                            }
                        }
                    }
                }
            }
            Queue<List<String>> temp = current;
            current = next;
            next = temp;
        }
        return result;
    }


    private boolean confirEnd(int[] map, int step, List<String> dictList, String end) {
        return match(end, dictList.get(map[step]));
    }

    //判断下一步是否合适
    private boolean confirBefore(int[] map, int step, List<String> dictList, String start) {
        if (step == 0) {
            return match(start, dictList.get(map[step]));
        } else {
            for (int i = 0; i < step; i++) {
                if (map[i] == map[step]) {
                    return false;
                }
            }
            return match(dictList.get(map[step - 1]), dictList.get(map[step]));
        }
    }

    //相差一个
    private boolean match(String start, String end) {
        int len = start.length();
        boolean one = false;
        for (int i = 0; i < len; i++) {
            if (start.charAt(i) != end.charAt(i)) {
                if (one) {
                    return false;
                } else {
                    one = true;
                }
            }
        }
        return one;
    }

    private void getShortest(List<List<String>> lists) {
        int num = Integer.MAX_VALUE;
        for (List<String> list : lists) {
            num = Math.min(num, list.size());
        }
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() > num) {
                lists.remove(i);
                i--;
            }
        }
    }

    private Set<String> copy(Set<String> set) {
        Set<String> res = new HashSet<>();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            res.add(iterator.next());
        }
        return res;
    }


    public static void main(String[] args) {
        LintCode_121 lintCode_121 = new LintCode_121();
        Set<String> dict = new HashSet<>();
        String[] strings = new String[]{"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        for (String s : strings) {
            dict.add(s);
        }
        List<List<String>> ladders = lintCode_121.findLadders_V1("qa", "sq", dict);
        System.out.println(ladders);
    }
}
