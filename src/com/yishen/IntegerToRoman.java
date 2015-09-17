package com.yishen;

import java.util.HashMap;

/**
 * Created by yishen on 15/7/17.
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(1999));
    }

    @SuppressWarnings("serial")
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return null;
        }

        HashMap<Integer, String> tmap = new HashMap<Integer, String>() {
            {
                put(0, "");
                put(1, "M");
                put(2, "MM");
                put(3, "MMM");
            }
        };

        HashMap<Integer, String> hmap = new HashMap<Integer, String>() {
            {
                put(0, "");
                put(1, "C");
                put(2, "CC");
                put(3, "CCC");
                put(4, "CD");
                put(5, "D");
                put(6, "DC");
                put(7, "DCC");
                put(8, "DCCC");
                put(9, "CM");
            }
        };

        HashMap<Integer, String> dmap = new HashMap<Integer, String>() {
            {
                put(0, "");
                put(1, "X");
                put(2, "XX");
                put(3, "XXX");
                put(4, "XL");
                put(5, "L");
                put(6, "LX");
                put(7, "LXX");
                put(8, "LXXX");
                put(9, "XC");
            }
        };

        HashMap<Integer, String> smap = new HashMap<Integer, String>() {
            {
                put(0, "");
                put(1, "I");
                put(2, "II");
                put(3, "III");
                put(4, "IV");
                put(5, "V");
                put(6, "VI");
                put(7, "VII");
                put(8, "VIII");
                put(9, "IX");
            }
        };

        return tmap.get(num / 1000) + hmap.get((num - (num / 1000) * 1000) / 100)
                + dmap.get((num - (num / 100) * 100) / 10) + smap.get(num - (num / 10) * 10);
    }
}
