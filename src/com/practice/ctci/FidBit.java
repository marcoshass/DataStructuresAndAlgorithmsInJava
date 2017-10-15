package com.practice.ctci;

public class FidBit {

	public static void main(String[] args) {
		int numberToCheck = 114;
		System.out.println(getLongestBitCount(numberToCheck));
	}
	
	static int getLongestBitCount(int x) {
		int maxCount = 0;
		int count = 0;
		boolean flagOne = false;
		
		while (x != 0) {
			if ((x & 1) == 1) {
				if (!flagOne) {
					flagOne = true;
				}
				count++;
			} else {
				if (flagOne) {
					x |= 1; // flip
					flagOne = false;
					count++;
				} else {
					count = 0;
				}
			}
			
			maxCount = count > maxCount ? count : maxCount;			
			x >>>= 1;
		}
		
		return maxCount;
	}

}
