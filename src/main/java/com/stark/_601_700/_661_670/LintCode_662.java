package com.stark._601_700._661_670;

import com.stark.entity.GuessGame;

/**
 * Created by Stark on 2017/11/16.
 * 我们正在玩猜数游戏。 游戏如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个号码。
 * 每次你猜错了，我会告诉你这个数字是高还是低。
 * 你调用一个预定义的接口 guess(int num)，它会返回 3 个可能的结果(-1，1或0):
 */
public class LintCode_662 extends GuessGame {

    public int guessNumber(int n) {
        // Write your code here
        int begin = 1;
        int end = n;
        while (begin < end) {
            int mid = (begin / 2 + end / 2);
            if (begin % 2 == 1 && end % 2 == 1) {
                mid++;
            }
            int guess = guess(mid);
            if (guess == 0) return mid;
            else if (guess == 1) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return 0;
    }
}
