package com.algorithms.recursion;

import java.util.Arrays;

public class StringsOfNBits {

	private int[] A = {-1, -1};

	public static void main(String[] args) {
		new StringsOfNBits().binary(0);
	}

	void binary(int n) {
		if (n == A.length) {
			System.out.print(Arrays.toString(A));
			return;
		}

		A[n] = 0;
		binary(n + 1);
		
		A[n] = 1;
		binary(n + 1);
	}

}
