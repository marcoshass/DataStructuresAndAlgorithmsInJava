package com.practice.epi.primitive;

public class ReverseBits {

	public static void main(String[] args) {
		long x = 0b10111111;
		//System.out.printf("original:%s, reverse:%s", Long.toBinaryString(x), Long.toBinaryString(reverseBits(x)));
		//System.out.printf("original:%s, reverse:%s", Long.toBinaryString(x), Long.toBinaryString(reverseBits1(x)));
		precomputedReverse();
	}
	
	// 1:: O(nbits)
	public static long reverseBits(long x) {
		long y = 0;
		
		while (x != 0) {
			y <<= 1;
			y |= (x & 1);
			x >>>= 1;
		}
		
		return y;
	}
	
	// 2:: table based
	public static long reverseBits1(long x) {
		final long BIT_MASK = 0b00000011;
		final int WORD_LENGTH = 2;
		return
				precomputedReverse()[(int)(x & BIT_MASK)] |
				x & (BIT_MASK << WORD_LENGTH) |
				x & (BIT_MASK << 2 * WORD_LENGTH |
				BIT_MASK << 3 * WORD_LENGTH; 
	}

	static final int CACHE_SIZE = 256;
	
	public static int[] precomputedReverse() {
		int[] cache = new int[CACHE_SIZE];
		for (int i = 0; i < CACHE_SIZE; i++) {
			cache[i] = (int)reverseBits(i);
		}
		return cache;
	}

}
