package com.practice.epi.primitive;

public class ParityOfWord {

	public static void main(String[] args) {
		int x = 0b0011001111111;
		System.out.printf("1:: brute-force-mod2=%d \n2:: brute-force-xor=%d \n3:: optimized (ones)=%d", parity(x),
				parity1(x), parity2(x));
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
	public static short parity1(int x) {
		short result = 0;
		while (x != 0) {
			result ^= (x & 1);
			x >>>= 1;
		}
		return result;
	}

	// 3:: optimized - n_of_ones
	public static short parity2(int x) {
		short result = 0;
		while (x != 0) {
			result ^= 1;
			x &= (x - 1);
		}
		return result;
	}
}
