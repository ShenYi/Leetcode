package com.yishen;

public class JumpGameII {

	public static void main(String[] args) {
		System.out.println(new JumpGameII().jump(new int[] { 100, 1, 2, 2, 3, 4, 5, 1, 5, 1, 5 }));
	}

	public int jump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] step = new int[nums.length];
		step[nums.length - 1] = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			int min = step[i + 1];
			for (int j = 2; j <= nums[i]; j++) {
				if (i + j < nums.length && step[i + j] < min) {
					min = step[i + j];
				}
			}

			step[i] = min + 1;
		}
		return step[0];
	}

}
