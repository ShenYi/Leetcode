package com.yishen;

import java.util.HashMap;

/**
 * Created by yishen on 15/7/17.
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.print(new RomanToInteger().romanToInt("MDCCCLXXX"));

    }

    @SuppressWarnings("serial")
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        HashMap<Character, Integer> mapping = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int number = mapping.get(s.charAt(0));
        int prev = number;
        for (int i = 1; i < s.length(); i++) {
            int currentNumber = mapping.get(s.charAt(i));
            if (currentNumber > prev) {
                number = number - prev + currentNumber - prev;
            } else {
                number += currentNumber;
            }
            prev = currentNumber;
        }
        return number;
    }
}
