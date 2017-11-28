package com.stark._601_700._641_650;

import com.stark._401_500._461_470.LintCode_463;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Stark on 2017/11/27.
 * 给定一个以上述格式表示文件系统的字符串，返回抽象文件系统中文件最长绝对路径的长度。如果系统中没有文件，则返回 0 。
 */
public class LintCode_643 {
    public int lengthLongestPath(String input) {
        // write your code here
        input += '\n';
        char[] temp = input.toCharArray();
        Stack<Integer> result = new Stack<Integer>();
        int len = 0;
        int depth = 0;
        int count = 0;
        boolean isFile = false;
        for (char aTemp : temp) {
            if (aTemp == '\n') {
                if (depth > 0) {
                    count += result.get(depth - 1) + 1;
                }
                while (result.size() > depth) {
                    result.pop();
                }
                result.push(count);
                if (isFile) {
                    len = Math.max(count, len);
                }
                count = 0;
                depth = 0;
                isFile = false;
            } else if (aTemp == '\t') {
                depth++;
            } else {
                count++;
                if (aTemp == '.') {
                    isFile = true;
                }
            }
        }
        return len;
        /*
        int res = 0;
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        int cur = 0;//层级
        boolean file = false;//找到文件
        boolean getLevel = false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '\n') {
                getLevel = true;
                if (file) {
                    res = Math.max(res, sb.length());
                    file = false;
                }
            } else if (c == '\t') {
                cur++;

            } else if (c == '.') {
                file = true;
                sb.append(c);
            } else {
                if (getLevel) {
                    if (map.containsKey(cur)) {
                        int i1 = map.get(cur) - 1;
                        int l2 = sb.length();
                        if (l2 > i1) {
                            sb.delete(map.get(cur) - 1, sb.length());
                            map.remove(cur);
                        }
                    }
                    sb.append("/");
                    map.put(cur, sb.length());
                    cur = 0;
                    getLevel = false;
                }
                sb.append(c);
            }
        }
        if (file) {
            res = Math.max(res, sb.length());
        }
        return res;*/
    }

    public static void main(String[] args) {

        //String str = "sladjf\n\tlkjlkv\n\t\tlkjlakjlert\n\t\t\tlaskjglaksjf\n\t\t\t\tlakjgfljrtlj\n\t\t\t\t\tlskajflakjsvlj\n\t\t\t\t\t\tlskgjflkjrtlrjt\n\t\t\t\t\t\t\tlkjglkjlvkjdlvkj\n\t\t\t\t\t\t\t\tlfjkglkjfljdlv\n\t\t\t\t\t\t\t\t\tlkdfjglerjtkrjkljsd.lkvjlkajlfk\n\t\t\t\t\t\t\tlskfjlksjljslvjxjlvkzjljajoiwjejlskjslfj.slkjflskjldfkjoietruioskljfkljf\n\t\t\t\t\tlkasjfljsaljlxkcjzljvl.asljlksaj\n\t\t\t\tasldjflksajf\n\t\t\t\talskjflkasjlvkja\n\t\t\t\twioeuoiwutrljsgfjlskfg\n\t\t\t\taslkjvlksjvlkjsflgj\n\t\t\t\t\tlkvnlksfgk.salfkjaslfjskljfv\n\t\t\tlksdjflsajlkfj\n\t\t\tlasjflaskjlk\n\t\tlsakjflkasjfkljas\n\t\tlskjvljvlkjlsjfkgljfg\n\tsaljkglksajvlkjvkljlkjvksdj\n\tlsakjglksajkvjlkjdklvj\n\tlskjflksjglkdjbkljdbkjslkj\n\t\tlkjglkfjkljsdflj\n\t\t\tlskjfglkjdfgkljsdflj\n\t\t\t\tlkfjglksdjlkjbsdlkjbk\n\t\t\t\t\tlkfgjlejrtljkljsdflgjl\n\t\t\t\t\tsalgkfjlksfjgkljsgfjl\n\t\t\t\t\tsalkflajwoieu\n\t\t\t\t\t\tlaskjfglsjfgljkkvjsdlkjbklds\n\t\t\t\t\t\t\tlasjglriotuojgkjsldfgjsklfgjl\n\t\t\t\t\t\t\t\tlkajglkjskljsdljblkdfjblfjlbjs\n\t\t\t\t\t\t\t\t\tlkajgljroituksfglkjslkjgoi\n\t\t\t\t\t\t\t\t\t\tlkjglkjkljkljdkbljsdfljgklfdj\n\t\t\t\t\t\t\t\t\t\t\tlkjlgkjljgslkdkldjblkj\n\t\t\t\t\t\t\t\t\t\t\t\tlkjfglkjlkjbsdklj.slgfjalksjglkfjglf\n\t\t\t\t\t\t\t\t\t\t\t\tlkasjrlkjwlrjljsl\n\t\t\t\t\t\t\t\t\t\t\t\t\tlksjgflkjfklgjljbljls\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjsglkjlkjfkljdklbjkldf\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjglkjdlsfjdglsdjgjlxljjlrjsgjsjlk\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjsgkllksjfgjljdslfkjlkasjdflkjxcljvlkjsgkljsfg\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlaskjlkjsakljglsdjfgksdjlkgjdlskjb\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkajsgfljfklgjlkdjgfklsdjklj\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjfglkjlkgjlkjl.aslkjflasjlajglkjaf\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjasflgjlskjglkfjgklgsdjflkbjsdklfjskldfjgklsfdjgklfdjgl\n\tlskadjlkjsldwwwwwfj\n\t\tlkjflkasjlfjlkjajslfkjlasjkdlfjlaskjalvwwwwwwwwwwwwwwwkjlsjfglkjalsjgflkjaljlkdsjslbjsljksldjlsjdlkjljvblkjlkajfljgasljfkajgfljfjgldjblkjsdljgsldjg.skljf";
        String str = "dir\nfile.txt";
        System.out.println(new LintCode_643().
                lengthLongestPath(str));
    }
}
