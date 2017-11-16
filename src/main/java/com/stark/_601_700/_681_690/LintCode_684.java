package com.stark._601_700._681_690;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Stark on 2017/11/16.
 * 给出两个字符串，你需要找到缺少的字符串
 */
public class LintCode_684 {
    //str1中有而str2中没有
    public List<String> missingString(String str1, String str2) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (str1.isEmpty()) return res;
        String[] split = str1.split(" ");
        if (str2.isEmpty()) {
            for (String s : split) {
                res.add(s);
            }
            return res;
        }
        Set<String> set = new HashSet<String>();
        String[] split1 = str2.split("_");
        for(String s:split1){
            set.add(s);
        }
        for (String s:split){
            if(!set.contains(s)){
                res.add(s);
            }
        }
        return res;
    }
}
