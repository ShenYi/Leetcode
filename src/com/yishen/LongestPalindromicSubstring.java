package com.yishen;

/**
 * Created by yishen on 15/7/12.
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    boolean[][] calculated;
    boolean[][] mapping;

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome2(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        mapping = new boolean[s.length()][s.length()];
        int maxI = 0;
        int maxJ = 0;
        for (int k = 0; k < s.length(); k++) {
            for (int i = 0; i < s.length() - k; i++) {
                int j = i + k;
                mapping[i][j] = k == 0 || ((s.charAt(i) == s.charAt(j)) && ((k == 1) || mapping[i + 1][j - 1]));
                if (mapping[i][j]) {
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        return s.substring(maxI, maxJ + 1);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        mapping = new boolean[s.length()][s.length()];
        calculated = new boolean[s.length()][s.length()];

        for (int k = s.length() - 1; k >= 0; k--) {
            for (int i = 0; i < s.length() - k; i++) {
                int j = i + k;
                if (isPalindrome(s, i, j)) {
                    return s.substring(i, j + 1);
                }
            }
        }
        return null;
    }

    public boolean isPalindrome(String s, int start, int end) {
        if (!calculated[start][end]) {
            if (start == end) {
                mapping[start][end] = true;
            } else if (start == end - 1) {
                mapping[start][end] = (s.charAt(start) == s.charAt(end));
            } else {
                mapping[start][end] = (s.charAt(start) == s.charAt(end))
                        && isPalindrome(s, start + 1, end - 1);
            }
        }
        calculated[start][end] = true;
        return mapping[start][end];
    }
}
