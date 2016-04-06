package com.yishen;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-for-a-range/
 * 
 * @author yishen
 *
 */
public class SearchForARange {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new SearchForARange().searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 7)));
	}

	public int[] searchRange(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;

		int root = -1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (nums[m] > target) {
				r = m - 1;
			} else if (nums[m] < target) {
				l = m + 1;
			} else {
				root = m;
				break;
			}
		}

		if (root != -1) {
			l = root - 1;
			r = root + 1;
			while (l >= 0 && nums[l] == target) {
				l--;
			}
			while (r < nums.length && nums[r] == target) {
				r++;
			}
			return new int[] { l + 1, r - 1 };
		} else {
			return new int[] { -1, -1 };
		}
	}
}
