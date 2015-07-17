package com.yishen;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yishen on 15/7/11.
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums  == null || nums.length < 2) {
            return null;
        }
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int lookFor = target - nums[i];
            if (m.containsKey(lookFor)) {
                return new int[] {m.get(lookFor) + 1, i + 1};
            }
            m.put(nums[i], i);
        }
        return null;
    }
}
