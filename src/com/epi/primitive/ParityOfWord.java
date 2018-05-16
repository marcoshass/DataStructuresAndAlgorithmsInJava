package com.epi.primitive;

public class ParityOfWord {

	public static void main(String[] args) {
		long x = 0b11010110;
		System.out.printf("1:: brute-force-mod2=%d"
				+ " \n2:: brute-force-xor=%d"
				+ " \n3:: optimized (ones)=%d"
				+ " \n4:: lookup-table=%d"
				+ " \n5:: xor=%d",
				parity(x),
				parity1(x),
				parity2(x),
				parity3(x),
				parity4(x));
	}

	// 1:: brute force - mod 2
	public static short parity(long x) {
		short result = 0;
		while (x != 0) {
			result += (x & 1);
			x >>>= 1;
		}
		return (short) (result % 2);
	}

	// 2:: brute force - xor
	public static short parity1(long x) {
		short result = 0;
		while (x != 0) {
			result ^= (x & 1);
			x >>>= 1;
		}
		return result;
	}

	// 3:: optimized - n_of_ones
	public static short parity2(long x) {
		short result = 0;
		while (x != 0) {
			result ^= 1;
			x &= (x - 1);
		}
		return result;
	}
	
	// 4:: lookup based
	public static short parity3(long x) {
		final int WORD_SIZE = 16;
		final int BIT_MASK = 0b1111111111111111;
		
		return (short)(
				precomputedparity()[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)] ^
				precomputedparity()[(int) ((x >>> (2 * WORD_SIZE)) & BIT_MASK)] ^
				precomputedparity()[(int) ((x >>> (1 * WORD_SIZE)) & BIT_MASK)] ^
				precomputedparity()[(int) (x & BIT_MASK)]);
	}

	// 5:: xor
	public static short parity4(long x) {
		x ^= x >>> 32;		
		x ^= x >>> 16;		
		x ^= x >>> 8;		
		x ^= x >>> 4;
		x ^= x >>> 2;
		x ^= x >>> 1;
		return (short) (x & 1);
	}

	static short[] precomputedparity() {
		final int CACHE_SIZE = 65536;
		short[] cache = new short[CACHE_SIZE];
		
		for (int i = 0; i < CACHE_SIZE; ++i) {
			cache[i] = parity2(i);
		}
		return cache;
	}
	
}
