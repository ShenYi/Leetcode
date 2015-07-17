package com.yishen;

/**
 * Created by yishen on 15/7/16.
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("", "b*"));

    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        if (p.length() == 0) {
            return s.length() == 0;
        } else if (s.length() == 0) {
            int i = 0;
            if (p.length() % 2 == 0) {
                while (i < p.length() && p.charAt(i + 1) == '*') {
                    i += 2;
                }
            }
            return i == p.length();
        } else if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        }

        char a = s.charAt(0);
        char p1 = p.charAt(0);
        char p2 = p.charAt(1);
        if (p2 != '*') {
            return (p1 == '.' || a == p1) && isMatch(s.substring(1), p.substring(1));
        }

        if (p1 != '.') {
            int i = 0;
            boolean isEqual = true;
            while (isEqual && i < s.length()) {
                if (isMatch(s.substring(i), p.substring(2))) {
                    return true;
                }
                isEqual = s.charAt(i) == p1;
                i++;
            }
            return isEqual && isMatch(s.substring(s.length()), p.substring(2));
        }

        int i = 0;
        while (i <= s.length()) {
            if (isMatch(s.substring(i), p.substring(2))) {
                return true;
            }
            i++;
        }
        return false;
    }
}
