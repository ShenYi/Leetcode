package com.yishen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("wordgoodgoodgoodbestword",
				new String[] { "word", "good", "best", "good" }));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		final List<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return result;
		}

		int totalLength = words.length * words[0].length();
		Map<String, Integer> mapping = new HashMap<>();
		for (String word : words) {
			if (mapping.containsKey(word)) {
				mapping.put(word, mapping.get(word) + 1);
			} else {
				mapping.put(word, 1);
			}
		}
		
		int i = 0;
		Map<String, Integer> temp = new HashMap<>(mapping);
		while (i <= s.length() - totalLength) {
			for (int j = i; j < i + totalLength; j += words[0].length()) {
				String currentWord = s.substring(j, j + words[0].length());

				if (temp.containsKey(currentWord) && temp.get(currentWord) != 0) {
					temp.put(currentWord, temp.get(currentWord) - 1);
				} else {
					break;
				}
			}
			boolean match = true;
			for (Integer val : temp.values()) {
				if (val != 0) {
					match = false;
					break;
				}
			}
			if (match) {
				result.add(i);
			}
			i += 1;
			temp = new HashMap<>(mapping);
		}

		return result;
	}
}
