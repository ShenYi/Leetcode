package com.yishen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * 
 * @author yishen
 *
 */
public class CombinationSum {
	public static void main(String[] args) {
		System.out.println(new CombinationSum().combinationSum(new int[] { 2, 3, 6, 7 }, 6));

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		int[] c = Arrays.copyOf(candidates, candidates.length);
		Arrays.sort(c);
		int start = 0;
		int end = removeDuplicates(c);
		return helper(c, start, end, target);
	}

	public List<List<Integer>> helper(int[] c, int start, int end, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (start < end) {
			if (target > c[start]) {
				int pick = c[start];
				List<List<Integer>> r = helper(c, start, end, target - pick);
				for (List<Integer> l : r) {
					l.add(0, pick);
					result.add(l);
				}

				result.addAll(helper(c, start + 1, end, target));
			} else if (target == c[start]) {
				List<Integer> rr = new ArrayList<Integer>();
				rr.add(c[start]);
				result.add(rr);
			}
		}
		return result;
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
