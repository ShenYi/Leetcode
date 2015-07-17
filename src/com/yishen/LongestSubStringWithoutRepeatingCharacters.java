package com.yishen;

import java.util.HashMap;

/**
 * Created by yishen on 15/7/11.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Error1: currentLength added twice
 * Error2: Final calculation result discarded
 */
public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubStringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 1;

        int currentStart = 0;
        int currentLength = 0;
        HashMap<Character, Integer> sequence = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (sequence.containsKey(currentChar)) {
                int index = sequence.get(currentChar);

                if (index >= currentStart) {
                    currentStart = index + 1;
                    if (max < currentLength) {
                        max = currentLength;
                    }
                    currentLength = i - currentStart + 1;
                } else {
                    currentLength++;
                }
            } else {
                currentLength++;
            }
            sequence.put(currentChar, i);
        }
        return max > currentLength ? max: currentLength;
    }
}
