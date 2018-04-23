package com.practice.epi.primitive;

public class ReverseBits {

	public static void main(String[] args) {
		long x = 0b10111111;
		System.out.printf("original:%s, reverse:%s", Long.toBinaryString(x), Long.toBinaryString(reverseBits(x)));
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

}
