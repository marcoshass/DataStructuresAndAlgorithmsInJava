package com.practice.techdelight.arrays;

import java.util.*;

public class SubArrayWithSumZeroExists {

	static boolean zeroSumSubarray(int[] A) {
		Set<Integer> set = new HashSet<>();

		// insert 0 into set to handle the case when sub-array with
		// 0 sum starts from index 0
		set.add(0);

		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			// sum of elements so far
			sum += A[i];

			// if sum is seen before, we have found a sub-array with 0 sum
			if (set.contains(sum)) {
				return true;
			}

			// insert the sum so far into set
			set.add(sum);
		}

		// no sub-array with 0 sum exists
		return false;
	}

	public static void main(String[] args) {
		int[] A = { 7, 3, 4, -7, 3, 1 };
		if (zeroSumSubarray(A)) {
			System.out.println("Subarray exists");
		} else {
			System.out.println("Subarray does not exist");
		}
	}

}
