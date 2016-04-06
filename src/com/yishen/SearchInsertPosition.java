package com.yishen;

/**
 * https://leetcode.com/problems/search-insert-position/
 * 
 * @author yishen
 *
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		System.out.println(new SearchInsertPosition().searchInsert(new int[] { 1, 3, 5, 6 }, 2));
	}

	public int searchInsert(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;

		int mid = 0;

		while (l <= r) {
			mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		if (nums[mid] < target) {
			return mid + 1;
		}
		return mid;
	}
}
