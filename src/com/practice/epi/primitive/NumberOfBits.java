package com.practice.epi.primitive;

public class NumberOfBits {

	public static void main(String[] args) {
		int x = 0b11000101;
		System.out.printf("O(N):%d O(NBits):%d", countBits(x), countBits1(x));
	}

	static short countBits(int x) {
		short numBits = 0;
		while (x != 0) {
			numBits += (x & 1);
			x >>>= 1;
		}
		return numBits;
	}

	static int countBits1(int x) {
		int count = 0;
		while (x != 0) {
			count++;
			x &= (x - 1);
		}
		return count;
	}

}
