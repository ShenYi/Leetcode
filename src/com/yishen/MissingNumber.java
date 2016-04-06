package com.yishen;

public class MissingNumber {
	
	public static void main(String[] args) {
		System.out.println(new MissingNumber().missingNumber(new int[] {1,2,3}));
	}
	
	public int missingNumber(int[] nums) {
		int x = 0;

		for (int i = 0; i < nums.length; i++) {
			x ^= (i + 1);
			x ^= nums[i];
		}

		return x;
	}
}
