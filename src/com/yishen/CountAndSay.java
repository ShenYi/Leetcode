package com.yishen;

/**
 * https://leetcode.com/problems/count-and-say/
 * 
 * @author yishen
 *
 */
public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(5));
	}

	public String countAndSay(int n) {
		String init = "1";

		StringBuffer sb = new StringBuffer();
		while (n-- > 1) {
			sb.setLength(0);
			char prev = init.charAt(0);
			int count = 1;
			for (int i = 1; i < init.length(); i++) {
				if (prev == init.charAt(i)) {
					count++;
				} else {
					sb.append(count + String.valueOf(prev));
					count = 1;
					prev = init.charAt(i);
				}
			}
			sb.append(count + String.valueOf(prev));

			init = sb.toString();
		}

		return init.toString();
	}

}
