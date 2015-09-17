package com.yishen;

/**
 * Created by yishen on 15/9/2.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4, 4, 4, 4, 5, 6, 7, 7, 7, 7};

        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentNumber = nums[0];
        int i = 1;
        int moveTo = 1;

        while (i < nums.length) {
            if (nums[i] != currentNumber) {
                currentNumber = nums[i];
                nums[moveTo++] = currentNumber;
            }
            i++;
        }
        return moveTo;
    }
}
