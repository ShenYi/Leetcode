package com.yishen;

public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(new MultiplyStrings().multiply("9", "9"));
	}

	public String multiply(String num1, String num2) {
		String s1 = num1.length() > num2.length() ? num1 : num2;
		String s2 = num1.length() > num2.length() ? num2 : num1;

		String result = "0";
		for (int i = s2.length() - 1; i >= 0; i--) {
			String r = mulHelper(s1, s2.charAt(i), s2.length() - i);
			result = addHelper(result, r);
		}

		return result;
	}

	public String mulHelper(String num, char c, int power) {
		StringBuffer sb = new StringBuffer();

		if (c == '0') {
			return "0";
		}

		int m = (c - '0');

		int carry = 0;
		for (int i = num.length() - 1; i >= 0; i--) {
			char cc = num.charAt(i);
			int i1 = (cc - '0');
			int r = i1 * m + carry;
			if (r >= 10) {
				sb.append(r % 10);
				carry = r / 10;
			} else {
				sb.append(r);
				carry = 0;
			}
		}
		
		if (carry!=0) {
			sb.append(carry);
		}

		sb = sb.reverse();
		for (int i = 1; i < power; i++) {
			sb.append("0");
		}

		return sb.toString();
	}

	public String addHelper(String s1, String s2) {
		if (s1 == null) {
			return s2;
		} else if (s2 == null) {
			return s1;
		}

		StringBuffer sb = new StringBuffer();

		int carry = 0;
		for (int i = 1; i <= s1.length() && i <= s2.length(); i++) {
			char c1 = s1.charAt(s1.length() - i);
			char c2 = s2.charAt(s2.length() - i);

			int i1 = (c1 - '0');
			int i2 = (c2 - '0');
			int sum = i1 + i2 + carry;

			if (sum >= 10) {
				sb.append(sum - 10);
				carry = 1;
			} else {
				sb.append(sum);
				carry = 0;
			}
		}

		if (s1.length() != s2.length()) {
			String s = s1.length() > s2.length() ? s1 : s2;
			int gap = Math.abs(s1.length() - s2.length());
			for (int i = 1; i <= gap; i++) {
				char c = s.charAt(gap - i);
				int i1 = (c - '0');
				i1 += carry;
				if (i1 >= 10) {
					sb.append(i1 - 10);
					carry = 1;
				} else {
					sb.append(i1);
					carry = 0;
				}
			}
		}
		if(carry !=0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
}
