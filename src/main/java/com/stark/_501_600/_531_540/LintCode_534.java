package com.stark._501_600._531_540;

/**
 * Created by Stark on 2017/10/11.
 * 在上次打劫完一条街道之后，窃贼又发现了一个新的可以打劫的地方，但这次所有的房子围成了一个圈，这就意味着第一间房子和最后一间房子是挨着的。每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
 * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，你最多可以得到多少钱 在不触动报警装置的情况下。
 * 给出nums = [3,6,4], 返回　6，　你不能打劫3和4所在的房间，因为它们围成一个圈，是相邻的．
 */
public class LintCode_534 {
    public int houseRobber2(int[] nums) {
        // write your code here
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return 0;
        if (len == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
        if (len == 4) return Math.max(nums[0] + nums[2], nums[1] + nums[3]);
        //必有第一个
        int begin = 2;
        int end = len - 2;
        int[] dp_first = new int[end - begin + 1];
        dp_first[0] = nums[begin];
        dp_first[1] = Math.max(nums[begin + 1], nums[begin]);
        for (int i = 2; i <= end - begin; i++) {
            dp_first[i] = Math.max(dp_first[i - 1], dp_first[i - 2] + nums[i + begin]);
        }
        //必有最后一个
        begin = 1;
        end = len - 3;
        int[] dp_last = new int[end - begin + 1];
        dp_last[0] = nums[begin];
        dp_last[1] = Math.max(nums[begin + 1], nums[begin]);
        for (int i = 2; i <= end - begin; i++) {
            dp_last[i] = Math.max(dp_last[i - 1], dp_last[i - 2] + nums[i + begin]);
        }
        //两个都没选
        begin = 1;
        end = len - 2;
        int[] dp_both = new int[end - begin + 1];
        dp_both[0] = nums[begin];
        dp_both[1] = Math.max(nums[begin + 1], nums[begin]);
        for (int i = 2; i <= end - begin; i++) {
            dp_both[i] = Math.max(dp_both[i - 1], dp_both[i - 2] + nums[i + begin]);
        }
        int res = Math.max(dp_first[dp_first.length - 1] + nums[0], dp_last[dp_last.length - 1] + nums[len - 1]);

        return Math.max(dp_both[dp_both.length - 1], res);
    }

    public static void main(String[] args) {
        LintCode_534 tets = new LintCode_534();
        int i = tets.houseRobber2(new int[]{3, 6, 4, 3, 1, 4, 5, 6, 7});
        System.out.println(i);
    }
}
