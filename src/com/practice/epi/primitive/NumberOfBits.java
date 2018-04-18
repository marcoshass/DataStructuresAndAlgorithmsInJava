package com.practice.epi.primitive;

public class NumberOfBits {

	public static void main(String[] args) {
		int x = 0b11000101;
		System.out.printf("O(number_of_bits_set):%d O(number_of_ones_set):%d", numberOfBits(x),
				numberOfBitsImproved(x));
	}

	static int numberOfBits(int x) {
		int count = 0;
		while (x > 0) {
			count += (x & 1);
			x >>>= 1;
		}
		return count;
	}

	static int numberOfBitsImproved(int x) {
		int count = 0;
		while (x > 0) {
			count++;
			x &= (x - 1);
		}
		return count;
	}

}
