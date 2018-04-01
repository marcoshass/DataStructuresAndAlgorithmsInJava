package com.algorithms.leetcode;

import java.util.*;

public class TwoSum {
	public static void main(String[] args) {
		int[] result = twoSum(new int[] { 2, 7, 11, 15 }, 9);
		System.out.println("Indexes:" + Arrays.toString(result));
	}

	static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			map.put(nums[i], i);
		}

		return new int[0];
	}
}
