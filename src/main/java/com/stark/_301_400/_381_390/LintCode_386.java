package com.stark._301_400._381_390;

public class LintCode_386 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.isEmpty()) return 0;
        int[] map = new int[128];
        char[] chars = s.toCharArray();
        int head = 0;
        int tail = 0;
        int res = 0;
        int cur = 0;
        for (; head < s.length(); head++) {
            if (map[chars[head]]++ == 0) {
                if (++cur > k) {
                    res = Math.max(head - tail, res);
                    while (tail <= head) {
                        if (--map[chars[tail]] == 0) {
                            cur--;
                            tail++;
                            break;
                        }
                        tail++;
                    }
                }
            }
        }
        res = Math.max(head - tail, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode_386().lengthOfLongestSubstringKDistinct("world", 5));
    }

}
