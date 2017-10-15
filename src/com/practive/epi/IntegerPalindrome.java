package com.practive.epi;

public class IntegerPalindrome {

	public static void main(String[] args) {
		System.out.println(multiply(4, 4));
	}
	
	static int multiply(int x, int y) {
		int sum = 0;
		while (x != 0) {
			if ((x & 1) != 0) {
				sum = add(sum, y);
			}
			x >>>= 1;
			y <<= 1;
		}
		return sum;
	}

	static int add(int x, int y)
	{
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}
	
}
