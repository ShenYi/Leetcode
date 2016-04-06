package com.yishen;

/**
 * Created by yishen on 15/9/2.
 */
public class DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(new DivideTwoIntegers().divide(-2147483648, -2147483648));
	}

	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		boolean b1 = false;
		if (dividend == Integer.MIN_VALUE) {
			if (divisor == -1) {
				return Integer.MAX_VALUE;
			} else if (divisor == 1) {
				return Integer.MIN_VALUE;
			} else if (divisor == Integer.MIN_VALUE) {
				return 1;
			} else {
				dividend = dividend + Math.abs(divisor);
				b1 = true;
			}
		}

		if (divisor == Integer.MIN_VALUE) {
			return 0;
		}

		boolean flag = (((dividend & Integer.MIN_VALUE) >>> 31) ^ ((divisor & Integer.MIN_VALUE) >>> 31)) == 0;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int result = 0;

		while (true) {
			if (dividend < divisor) {
				break;
			}

			int i = divisor;
			int j = 1;

			while (true) {
				if (((Integer.MIN_VALUE >>> 1) & i) > 0) {
					break;
				}
				if ((i << 1) >= dividend) {
					break;
				}
				i <<= 1;
				j <<= 1;
			}
			result += j;
			dividend -= i;
		}

		result = b1 ? result + 1 : result;
		return flag ? result : -result;
	}
}
