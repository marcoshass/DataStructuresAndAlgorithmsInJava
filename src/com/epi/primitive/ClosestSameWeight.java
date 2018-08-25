package com.epi.primitive;

public class ClosestSameWeight {

	public static void main(String[] args) {
		long intToFind = 92;
		System.out.printf("(book) closest of %d: %d", intToFind, closestIntSameBitCount(intToFind));
		System.out.printf("\n(mine) closest of %d: %d", intToFind, closestIntSameBitCount1(intToFind));
	}
	
    public static long closestIntSameBitCount(long x) {
		final int NUM_UNSIGNED_BITS = 63;

		for (int i = 0; i < NUM_UNSIGNED_BITS - 1; ++i) {
			if ((((x >>> i) & 1) != ((x >>> (i + 1)) & 1))) {
				x ^= (1L << i) | (1L << (i + 1));
				return x;
			}
		}

		throw new IllegalArgumentException("All bits are 0 or 1");
	}

	public static long closestIntSameBitCount1(long original) {
		final int MASK = 3;
		long numberToIterate = original;
		int offset = 0;
		
		while (numberToIterate > 0) {
			if ((numberToIterate & MASK) == 2 || (numberToIterate & MASK) == 1) {
				return (MASK << offset) ^ original;				
			}
			offset++;
			numberToIterate >>>= 1;
		}
		throw new IllegalArgumentException("All bits are 0 or 1");
	}
}
