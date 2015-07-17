package com.yishen;

/**
 * Created by yishen on 15/7/15.
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(100));
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean isNegative = x < 0;
        x = x > 0 ? x : -x;

        long i = 0;
        while (x > 0) {
            i = i * 10 + (x % 10);
            x = x / 10;
        }
        if ((!isNegative && i > Integer.MAX_VALUE) || (isNegative && -i < Integer.MIN_VALUE)) {
            return 0;
        }
        return (int) (isNegative ? -i : i);
    }
}
