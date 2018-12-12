package com.epi.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComputingAlternation {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[] {
			9, 12, 0, 3, 11, 15, 1, 18, 2
		});
		rearrange(A);
		System.out.println(A);
	}

	public static void rearrange(List<Integer> A) {
		for (int i = 1; i < A.size(); ++i) {
			if (((i % 2) == 0 && A.get(i - 1) < A.get(i))
				|| ((i % 2) != 0 && A.get(i - 1) > A.get(i))) {
				Collections.swap(A, i - 1, i);
			}
		}
	}

}
