package com.yishen;

/**
 * Created by yishen on 15/7/15.
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 100));
    }

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows <= 0 || numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < numRows; i++) {
            boolean isVertical = true;
            boolean isBottom = (i == (numRows - 1));
            boolean isTop = (i == 0);

            int j = i;
            while (j < s.length()) {
                sb.append(s.charAt(j));
                if (isVertical && !isBottom) {
                    j += ((numRows - i - 1) * 2);
                } else {
                    j += (i * 2);
                }
                isVertical = isTop ? isVertical : !isVertical;
            }
        }
        return sb.toString();
    }
}
