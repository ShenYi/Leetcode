package com.yishen;

/**
 * Created by yishen on 15/7/15.
 * https://leetcode.com/problems/string-to-integer-atoi/solution/
 */
public class StringToIntegerAtoi {
	public static void main(String[] args) {
		// int x = 2147483647;
		System.out.print(new StringToIntegerAtoi().myAtoi("010"));
	}

	public int myAtoi(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}

		int i = 0;
		while (str.charAt(i) == ' ') {
			i++;
		}

		boolean isPositive = true;
		if (str.charAt(i) == '+') {
			i++;
		} else if (str.charAt(i) == '-') {
			i++;
			isPositive = false;
		}

		while (i < str.length() && str.charAt(i) == '0') {
			i++;
		}

		int number = 0;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			int currentNumber = str.charAt(i) - '0';
			if (number > 214748364
					|| (number == 214748364 && (isPositive && currentNumber > 7 || !isPositive && currentNumber > 8))) {
				return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			number = number * 10 + (str.charAt(i) - '0');
			i++;
		}

		return isPositive ? number : -number;
	}
}
