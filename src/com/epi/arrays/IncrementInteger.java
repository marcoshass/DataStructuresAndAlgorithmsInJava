package com.epi.arrays;

import java.util.ArrayList;
import java.util.List;

public class IncrementInteger {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(9);
		System.out.println(A);
		System.out.println(plusOne(A));
	}

	public static List<Integer> plusOne(List<Integer> A) {
		int n = A.size() - 1;
		int carry = 1;

		for (int i = n; i >= 0 && carry > 0; --i) {
			int sum = A.get(i) + carry;
			A.set(i, sum > 9 ? 0 : sum);
			carry = A.get(i) == 0 ? 1 : 0;
		}

		return A;
	}

}
