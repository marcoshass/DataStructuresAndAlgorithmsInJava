package com.practice.epi.primitive;

public class ParityOfWord {

	public static void main(String[] args) {
		int x = 0b0011001111111;
		System.out.printf("parity=%d", parity(x));
	}

	// 1:: brute force
	public static int parity(long x) {
		short parity = 0;
		while (x != 0) {
			parity += (x & 1);
			x >>>= 1;
		}
		return parity % 2;
	}

}
