package com.yishen;

import java.util.Arrays;

/**
 * Created by yishen on 15/7/18.
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public static int t = 0;

    public static void main(String[] args) {
        t = 0;
        System.out.println(new ThreeSumClosest().threeSumClosest(
                new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
        System.out.println(t);
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];

        int i = 0;
        int j = nums.length - 1;
        while (i + 2 <= j && closest != target) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j--;
                continue;
            }
            int sum = nums[i] + nums[j];

            for (int k = i + 1; k < j; k++) {
                t++;
                System.out.println(nums[i] + " " + nums[k] + " " + nums[j] + " " + closest);
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum > target) {
                    break;
                }
            }

            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                if(sum > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return closest;
    }
}
