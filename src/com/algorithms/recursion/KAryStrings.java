package com.algorithms.recursion;

import java.util.Arrays;

public class KAryStrings {

	private int[] A = new int[4]; // 0 0 0 0
	
	public static void main(String[] args) {
		new KAryStrings().kAry(3, 4);
	}

	public void kAry(int n, int k) { // k = 4 => 1, 2, 3, 4
		if (n < 0) {
			System.out.println(Arrays.toString(A));
		} else {
			for (int i = 1; i <= k; i++) {
				A[n] = i;
				kAry(n - 1, k);
			}
			
		}
	}
	
}
