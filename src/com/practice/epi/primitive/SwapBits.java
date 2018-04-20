package com.practice.epi.primitive;

public class SwapBits {

	public static void main(String[] args) {
		long x = 0b01001001;
		System.out.printf("original:%d swap:%d", x, swapBits(x, 1, 6));
	}

	// O(1) complexity
	public static long swapBits(long x, int i, int j) {
		if (((x >>> i) & 1) != ((x >>> j) & 1)) {
			return x ^ (1L << i | 1L << j);
		}
		return x;
	}

}
