package com.yishen;

/**
 * Created by yishen on 15/7/15.
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.print(new PalindromeNumber().isPalindrome(-12121));

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int digit = 0;
        int num = x;
        while (num != 0) {
            digit++;
            num /= 10;
        }

        int length = digit;

        while (digit >= length / 2) {
            num = x;
            int i = 0;
            while (i++ < length - digit) {
                num /= 10;
            }
            int low = num % 10;
            i = 0;
            while (++i < 2 * digit - length) {
                num /= 10;
            }
            int high = num % 10;

            if (high != low) {
                return false;
            }
            digit--;
        }
        return true;
    }
}
