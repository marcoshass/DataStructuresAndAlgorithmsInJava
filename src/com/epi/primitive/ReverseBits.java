package com.epi.primitive;

public class ReverseBits {

	static long[] precomputedReverse = new long[65536];

	static {
		for (int i = 0; i < precomputedReverse.length; i++) {
			precomputedReverse[i] = reverseBits(i);
		}
	}
	
	public static void main(String[] args) {
		long x = 0b10010011l;
		System.out.printf("original:%s, reverse=%s", Long.toBinaryString(x), Long.toBinaryString(reverseBits(x)));
		System.out.printf("\noriginal:%s, reverse=%s <--table", Long.toBinaryString(x), Long.toBinaryString(reverseBitsTable(x)));
	}
	
	// 1:: O(nbits)
	static long reverseBits(long x) {
		long y = 0;
		
		while (x != 0) {
			y <<= 1;
			y |= x & 1;
			x >>>= 1;
		}
		
		return y;
	}
	
	// 2:: Table-based version
	static long reverseBitsTable(long x) {
		final int MASK_SIZE = 16;
		final int BIT_MASK = 0xFFFF;
		
		return precomputedReverse[(int) (x & BIT_MASK)] << (3 * MASK_SIZE)
				| precomputedReverse[(int) ((x >>> MASK_SIZE) & BIT_MASK)] << (2 * MASK_SIZE)
				| precomputedReverse[(int) ((x >>> (2 * MASK_SIZE)) & BIT_MASK)] << MASK_SIZE
				| precomputedReverse[(int) ((x >>> (3 * MASK_SIZE)) & BIT_MASK)];
	}
	
}
