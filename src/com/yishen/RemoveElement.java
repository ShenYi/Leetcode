package com.yishen;

import java.util.Arrays;

/**
 * Created by yishen on 15/9/2.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 5, 4, 3, 4, 0, 6, 7, 7, 7, 7};
        new RemoveElement().removeElement(nums, 3);

        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int moveTo = 0;

        while (i < nums.length) {
            if (nums[i] != val) {
                nums[moveTo++] = nums[i];
            }
            i++;
        }
        return moveTo;
    }
}
