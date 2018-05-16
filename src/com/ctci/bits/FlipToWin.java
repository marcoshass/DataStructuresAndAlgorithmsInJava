package com.ctci.bits;

public class FlipToWin {

	public static void main(String[] args) {
		int x = 0b11011101111;
		flipBits(x);
		//System.out.printf("\n%d", flipBits(x));
	}
	
	static int flipBits(int a) {
		while (a != 0) {
			if ((a & 3) == 2) {
				System.out.println(a);
			}
			a >>>= 1;
		}
		return a;
	}

}
