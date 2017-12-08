package com.stark._701_800._731_740;

/**
 * Created by Stark on 2017/12/7.
 */
public class LintCode_739 {
    public boolean compute24(double[] nums) {
        // write your code here
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                double[] ints = new double[3];
                int n = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != i && k != j) ints[n++] = nums[k];
                }
                ints[n] = nums[i] / nums[j];
                if (countThree(ints, 24)) return true;
                ints[n] = nums[i] * nums[j];
                if (countThree(ints, 24)) return true;
                ints[n] = nums[i] - nums[j];
                if (countThree(ints, 24)) return true;
                ints[n] = nums[i] + nums[j];
                if (countThree(ints, 24)) return true;
                ints[n] = nums[j] - nums[i];
                if (countThree(ints, 24)) return true;
                ints[n] = nums[j] / nums[i];
                if (countThree(ints, 24)) return true;
            }
        }
        return false;
    }

    public boolean countThree(double[] nums, double target) {
        for (int i = 0; i < 3; i++) {
            double[] ints = new double[2];
            int n = 0;
            for (int k = 0; k < 3; k++) {
                if (k != i) ints[n++] = nums[k];
            }

            if (nums[i] != 0 && countTwo(ints, nums[i] / target))
                return true;
            if (nums[i] != 0 && countTwo(ints, nums[i] * target))
                return true;
            if (countTwo(ints, nums[i] - target))
                return true;
            if (countTwo(ints, nums[i] + target))
                return true;
            if (countTwo(ints, target - nums[i]))
                return true;
            if (nums[i] != 0 && countTwo(ints, target / nums[i]))
                return true;
        }
        return false;
    }

    private boolean countTwo(double[] nums, double target) {
        if (Math.abs(nums[0] / nums[1] - target) <= 0.000001) {
            return true;
        }
        if (Math.abs(nums[0] * nums[1] - target) <= 0.000001) {
            return true;
        }
        if (Math.abs(nums[0] + nums[1] - target) <= 0.000001) {
            return true;
        }
        if (Math.abs(nums[0] - nums[1] - target) <= 0.000001) {
            return true;
        }
        if (Math.abs(nums[1] / nums[0] - target) <= 0.000001) {
            return true;
        }
        if (Math.abs(nums[1] - nums[0] - target) <= 0.000001) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LintCode_739 test = new LintCode_739();
        boolean b = test.compute24(new double[]{8, 9, 8, 9});
        System.out.println(b);
    }
}
