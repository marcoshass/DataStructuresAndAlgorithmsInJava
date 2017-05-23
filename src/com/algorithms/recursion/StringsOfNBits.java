package com.algorithms.recursion;

import java.util.Arrays;

public class StringsOfNBits {

	private int[] A = new int[2];

	public static void main(String[] args) {
		StringsOfNBits s = new StringsOfNBits();
		s.binary(s.A.length - 1);
	}

	void binary(int n) {
		if (n < 0) {
			System.out.println(Arrays.toString(A));
			return;
		}
		
		A[n] = 0;
		binary(n - 1);
		
		A[n] = 1;
		binary(n - 1);
	}

}
