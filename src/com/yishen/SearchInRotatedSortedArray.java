package com.yishen;

public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		System.out.println(new SearchInRotatedSortedArray().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, -1));
	}

	public int search(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < nums[r]) {
				if (target > nums[mid] && target <= nums[r]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			} else {
				if (target < nums[mid] && target >= nums[l]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}

			}
		}
		return -1;
	}
}
