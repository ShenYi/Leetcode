package com.yishen;

/**
 * Created by yishen on 15/7/16.
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{2, 3, 10, 5, 7, 8, 9}));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        int i = 0;
        int j = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (i < j) {
            if (leftMax <= rightMax) {
                while (height[i] <= leftMax && i < j) {
                    i++;
                }
                leftMax = height[i];
                int current = (j - i) * (leftMax > rightMax ? rightMax : leftMax);

                if (current > max) {
                    max = current;
                }
            } else {
                while (height[j] <= rightMax && j > i) {
                    j--;
                }
                rightMax = height[j];
                int current = (j - i) * (rightMax > leftMax ? leftMax : rightMax);

                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }


}
