package com.yishen;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 * @author yishen
 *
 */
public class NextPermutation {

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 3, 2 };
		new NextPermutation().nextPermutation(a);
		System.out.println(Arrays.toString(a));
	}

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int i = nums.length - 1;
		while (i >= 1 && nums[i] <= nums[i - 1]) {
			i--;
		}

		if (i != 0) {
			for (int j = nums.length - 1; j >= i; j--) {
				if (nums[i - 1] < nums[j]) {
					int k = nums[i - 1];
					nums[i - 1] = nums[j];
					nums[j] = k;
					break;
				}
			}
		}

		int p = i;
		int q = nums.length - 1;
		while (p < q) {
			int x = nums[p];
			nums[p] = nums[q];
			nums[q] = x;
			p++;
			q--;
		}
	}

}
