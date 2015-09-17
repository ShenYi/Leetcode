package com.yishen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yishen on 15/7/18.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        int a = digits.charAt(0) - '0' - 2;
        String s = mapping[a];
        List<String> rt = letterCombinations(digits.substring(1));
        for (char c : s.toCharArray()) {
            if (rt.isEmpty()) {
                result.add(String.valueOf(c));
            } else {
                for (String ss : rt) {
                    result.add(c + ss);
                }
            }
        }
        return result;
    }
}
