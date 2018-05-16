package com.ctci.bits;

public class FlipToWin {

	public static void main(String[] args) {
		int x = 0b11011101111;
		flipBits(x);
		//System.out.printf("\n%d", flipBits(x));
	}
	
	static int flipBits(int a) {
		while (a != 0) {
			System.out.printf("\ndecimal: %d %s: %b", a, Long.toBinaryString(a), (a & 3) == 1);
			a >>>= 1;
		}
		return a;
	}

}
