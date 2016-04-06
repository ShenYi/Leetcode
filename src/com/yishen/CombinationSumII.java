package com.yishen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		System.out.println(new CombinationSumII().combinationSum2(new int[] { 10, 1, 2,2,2,2, 7, 6, 1, 5 }, 8));
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		int[] c = Arrays.copyOf(candidates, candidates.length);
		Arrays.sort(c);
		return helper(c, 0, c.length, target);
	}

	public List<List<Integer>> helper(int[] c, int start, int end, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (start < end) {
			if (target > c[start]) {
				int pick = c[start];
				List<List<Integer>> r = helper(c, start + 1, end, target - pick);
				for (List<Integer> l : r) {
					l.add(0, pick);
					result.add(l);
				}

				int nextStart = start + 1;
				while (nextStart < end && c[nextStart] == pick) {
					nextStart++;
				}
				result.addAll(helper(c, nextStart, end, target));
			} else if (target == c[start]) {
				List<Integer> rr = new ArrayList<Integer>();
				rr.add(c[start]);
				result.add(rr);
			}
		}
		return result;
	}

}
