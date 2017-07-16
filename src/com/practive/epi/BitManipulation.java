package com.practive.epi;

public class BitManipulation {

	public static void main(String[] args) {
		int numberToCheck = 28;
		System.out.println(parity(numberToCheck));
	}
	
	static short countBits(int x) {
		short numBits = 0;

		while (x != 0) {
			numBits += x & 1;
			x >>>=1;
		}
		
		return numBits;
	}
	
	static short parity(int x) {
		short parity = 0; // even
		
		while (x != 0) {
			parity ^= x & 1;
			x >>>= 1;
		}
		
		return parity;
	}

}
